package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select(
            //language=PostgreSQL
            "SELECT " +
                    "books_id AS id," +
                    "isbn, " +
                    "name, " +
                    "genre, " +
                    "author, " +
                    "year " +
                    "FROM books u " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', name, author) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<Book> getBooks(@Param("search") String search);

    @Select("SELECT " +
            "books_id AS id," +
            "isbn, " +
            "name, " +
            "genre, " +
            "author, " +
            "year " +
            "FROM books u " +
            "WHERE books_id = #{id}")
    Book findById(@Param("id") int id);

    @Update("UPDATE books " +
            "SET isbn = #{isbn}," +
            "name = #{name}," +
            "genre = #{genre}," +
            "author = #{author}," +
            "year = #{year} " +
            "WHERE books_id = #{id}")
    void update(Book book);

    @Delete("DELETE FROM books WHERE books_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO books (isbn, name, genre, author, year) " +
            "VALUES(#{isbn}, #{name}, #{genre}, #{author}, #{year})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "books_id",
            statement = "select currval('books_books_id_seq')",
            resultType = Integer.class)
    void insert(Book book);
}
