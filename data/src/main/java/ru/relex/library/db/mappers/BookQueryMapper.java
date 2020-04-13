package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.relex.library.db.model.Book;

import java.util.List;

@Mapper
public interface BookQueryMapper {
    @Select(
            "select " +
                "books.books_id as id, " +
                "books.year as year, " +
                "books.author as author, " +
                "books.genre as genre, " +
                "books.name as name, " +
                "books.isbn as isbn " +
            "from " +
                "(select " +
                   "paper_book.books_id as book_id, " +
                   "count(*) as cnt " +
                "from book_history " +
                "inner join paper_book " +
                    "on book_history.paper_book_id = paper_book.paper_book_id " +
                "where status like 'CLAIMED' " +
                "group by paper_book.books_id " +
                "order by cnt desc " +
                ") as book " +
            "inner join books " +
                "on book.book_id=books.books_id " +
            "limit 10 ")
    List<Book> getPopBooks();
}
