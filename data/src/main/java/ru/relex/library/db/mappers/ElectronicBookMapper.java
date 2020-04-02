package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.ElectronicBook;

import java.util.List;

@Mapper
public interface ElectronicBookMapper {

    @Select(
            "SELECT " +
                    "e_book_id AS id," +
                    "books_id, " +
                    "type, " +
                    "edition, " +
                    "format, " +
                    "publish_year, " +
                    "publisher, " +
                    "file, " +
                    "file_type " +
                    "FROM e_book u " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', edition, publish_year, publisher) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<ElectronicBook> getElectronicBooks(@Param("search") String search);

    @Select("SELECT " +
            "e_book_id AS id," +
            "books_id, " +
            "type, " +
            "edition, " +
            "format, " +
            "publish_year, " +
            "publisher, " +
            "file, " +
            "file_type " +
            "FROM e_book u " +
            "WHERE e_book_id = #{id}")
    ElectronicBook findById(@Param("id") int id);

    @Update("UPDATE e_book " +
            "SET books_id = #{booksId}, " +
            "type = #{type}, " +
            "edition = #{edition}, " +
            "format = #{format}, " +
            "publish_year = #{publishYear}, " +
            "publisher = #{publisher}, " +
            "file = #{file}, " +
            "file_type = #{fileType} " +
            "WHERE e_book_id = #{id}")
    void update(ElectronicBook electronicBook);

    @Delete("DELETE FROM e_book WHERE e_book_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO e_book (books_id, type, edition, format, publish_year, publisher, file, file_type) " +
            "VALUES(#{booksId}, #{type}, #{edition}, #{format}, #{publishYear}, #{publisher}, #{file}, #{fileType} )")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "e_book_id",
            statement = "select currval('e_book_e_book_id_seq')",
            resultType = Integer.class)
    void insert(ElectronicBook electronicBook);
}