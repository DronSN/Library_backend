DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books
(
    books_id SERIAL PRIMARY KEY,
    isbn     VARCHAR(30) NULL,
    name     VARCHAR(100) NOT NULL,
    genre    VARCHAR(50) NULL,
    author   VARCHAR(50) NULL,
    year     CHAR(4)
);

INSERT INTO books (isbn,name,genre,author,year)
VALUES ('9785170438556', 'Преступление и наказание', 'Литература 19 века',
        'Федор Достоевский', '2008'),
       ('9785699324385', 'Граф Монте-Кристо', 'Исторические приключения',
        'Александр Дюма', '2009');

DROP TABLE IF EXISTS e_book CASCADE;
CREATE TABLE e_book(
    e_book_id    SERIAL PRIMARY KEY,
    books_id     INTEGER NOT NULL,
    type         VARCHAR(20) NOT NULL,
    edition      VARCHAR(50) NULL,
    format       VARCHAR(20) NOT NULL,
    publish_year CHAR(4) NULL,
    publisher    VARCHAR(50) NULL,
    file         VARCHAR(200) NOT NULL,
    file_type    VARCHAR(6) NOT NULL,
    CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books (books_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

DROP TABLE IF EXISTS paper_book CASCADE;
CREATE TABLE paper_book(
     paper_book_id    SERIAL PRIMARY KEY,
     books_id         INTEGER NOT NULL,
     type             VARCHAR(20) NOT NULL,
     edition          VARCHAR(50) NULL,
     format           VARCHAR(20) NOT NULL,
     publish_year     CHAR(4) NULL,
     publisher        VARCHAR(50) NULL,
     total_amount     INTEGER NOT NULL,
     free_amount      INTEGER NOT NULL,
     CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books (books_id)
         ON UPDATE CASCADE
         ON DELETE CASCADE
);

DROP TABLE IF EXISTS wait_list CASCADE;
CREATE TABLE wait_list(
    wait_list_id   SERIAL PRIMARY KEY,
    books_id       INTEGER NOT NULL ,
    user_id        INTEGER NOT NULL ,
    created_at     TIMESTAMP NOT NULL ,
    CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books(books_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE,
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS book_history CASCADE;
CREATE TABLE book_history(
    book_history_id SERIAL PRIMARY KEY,
    paper_book_id   INTEGER NOT NULL,
    user_id         INTEGER NOT NULL,
    status          VARCHAR(10) NOT NULL ,
    created_at      TIMESTAMP NOT NULL ,
    CONSTRAINT paper_books_fk FOREIGN KEY (paper_book_id) REFERENCES paper_book(paper_book_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS review CASCADE;
CREATE TABLE review(
    review_id SERIAL PRIMARY KEY,
    books_id       INTEGER NOT NULL,
    user_id        INTEGER NOT NULL,
    rank           INTEGER NOT NULL ,
    review         TEXT NOT NULL ,
    created_at     TIMESTAMP NOT NULL ,
    updated_at     TIMESTAMP,
    CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books(books_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS progress CASCADE;
CREATE TABLE progress(
    progress_id SERIAL PRIMARY KEY,
    books_id       INTEGER NOT NULL,
    user_id        INTEGER NOT NULL,
    page_got       INTEGER NOT NULL ,
    created_at     TIMESTAMP NOT NULL ,
    CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books(books_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS plan CASCADE;
CREATE TABLE plan(
  plan_id        SERIAL PRIMARY KEY,
  books_id       INTEGER NOT NULL,
  user_id        INTEGER NOT NULL,
  page_goal      INTEGER NOT NULL ,
  date_goal      TIMESTAMP NOT NULL ,
  CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books(books_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE,
  CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE
);