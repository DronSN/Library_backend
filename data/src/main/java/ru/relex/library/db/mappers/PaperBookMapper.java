package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.PaperBook;

import java.util.List;

@Mapper
public interface PaperBookMapper {

    @Select(
            "SELECT " +
                    "paper_book_id AS id," +
                    "books_id, " +
                    "edition, " +
                    "format, " +
                    "publish_year, " +
                    "publisher, " +
                    "total_amount, " +
                    "free_amount " +
                    "FROM paper_book u " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', edition, publish_year, publish_year) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<PaperBook> getPaperBooks(@Param("search") String search);

    @Select("SELECT " +
            "paper_book_id AS id," +
            "books_id, " +
            "edition, " +
            "format, " +
            "publish_year, " +
            "publisher, " +
            "total_amount, " +
            "free_amount " +
            "FROM paper_book u " +
            "WHERE paper_book_id = #{id}")
    PaperBook findById(@Param("id") int id);

    @Update("UPDATE paper_book " +
            "SET books_id = #{booksId}, " +
            "edition = #{edition}, " +
            "format = #{format}, " +
            "publish_year = #{publishYear}, " +
            "publisher = #{publisher}, " +
            "total_amount = #{totalAmount}, " +
            "free_amount = #{freeAmount} " +
            "WHERE paper_book_id = #{id}")
    void update(PaperBook paperBook);

    @Delete("DELETE FROM books WHERE paper_book_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO paper_book (books_id, edition, format, publish_year, publisher, total_amount,free_amount ) " +
            "VALUES(#{booksId}, #{edition}, #{format}, #{publishYear}, #{publisher}, #{totalAmount},#{freeAmount})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "paper_book_id",
            statement = "select currval('paper_book_paper_book_id_seq')",
            resultType = Integer.class)
    void insert(PaperBook paperBook);
}
