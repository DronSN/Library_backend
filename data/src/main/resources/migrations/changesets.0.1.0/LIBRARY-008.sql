-- Adding views and triggers

-- book_view
CREATE OR REPLACE VIEW public.book_view
AS
select books.*,
       COALESCE(allb.paper_book_count,0) as paper_book_count,
       COALESCE(freeb.free_book_count,0) as free_book_count
from books left join
     --all books
         (select books_id, count(paper_book_id) as paper_book_count
          from paper_book
          group by books_id) as allb
     on books.books_id = allb.books_id
           left join
     --free books
         (select pb.books_id, count(pb.paper_book_id) as free_book_count
          from paper_book pb left join book_history h
                                       on pb.last_hist_id = h.book_history_id
          where h.status = 'FREE' --free status
          group by pb.books_id) as freeb
     on books.books_id = freeb.books_id;

-- paper_book_view
CREATE OR REPLACE VIEW public.paper_book_view
AS
select b.*,
       h.user_id as last_user_id,
       h.status as cur_status,
       h.created_at as last_status_change
from paper_book b left join book_history h
                            on b.last_hist_id=h.book_history_id;

-- Trigger function for paper_book.last_hist_id
CREATE OR REPLACE FUNCTION t01_paper_book_last_hist_id_fill()
    RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS(select * from paper_book where paper_book_id = NEW.paper_book_id) THEN
        update paper_book
        set last_hist_id = NEW.book_history_id
        where paper_book_id = NEW.paper_book_id;
        RETURN NEW;
    ELSE
        RETURN NULL;
    END IF;
END;
$$ language 'plpgsql';

-- Trigger last_hist_id for paper_book
CREATE TRIGGER paper_book_last_hist_id_fill BEFORE INSERT OR UPDATE ON book_history
FOR EACH ROW EXECUTE PROCEDURE t01_paper_book_last_hist_id_fill();

-- Trigger function for book_history.paper_book_available_flg_fill
CREATE OR REPLACE FUNCTION t02_paper_book_available_flg_fill()
    RETURNS TRIGGER AS $$
DECLARE
    bk_id int;
BEGIN
    select books_id INTO STRICT bk_id
    from paper_book
    where paper_book_id = NEW.paper_book_id;

    IF NEW.status = 'FREE'
    THEN
        update books
        set paper_book_available_flg = 'Y'
        where books_id = bk_id AND paper_book_available_flg = 'N';
    ELSE
        IF EXISTS(
                select books_id
                from book_view
                where books_id = bk_id AND free_book_count = 0 AND paper_book_available_flg = 'Y')
        THEN
            update books
            set paper_book_available_flg = 'N'
            where books_id = bk_id;
        END IF;
    END IF;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Trigger paper_book_available_flg_fill for book_history
CREATE TRIGGER paper_book_available_flg_fill BEFORE INSERT OR UPDATE ON book_history FOR EACH ROW EXECUTE PROCEDURE t02_paper_book_available_flg_fill();