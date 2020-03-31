package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.BookHistory;

import java.util.List;

@Mapper
public interface BookHistoryMapper {

    @Select(
            "SELECT " +
                    "book_history_id AS id," +
                    "paper_book_id, " +
                    "user_id, " +
                    "status, " +
                    "created_at " +
                    "FROM book_history u "
    )
    List<BookHistory> getBookHistorys(@Param("search") String search);

    @Select("SELECT " +
            "book_history_id AS id," +
            "paper_book_id, " +
            "user_id, " +
            "status, " +
            "created_at " +
            "FROM book_history u " +
            "WHERE book_history_id = #{id}")
    BookHistory findById(@Param("id") int id);

    @Update("UPDATE book_history " +
            "SET paper_book_id = #{paperBookId}," +
            "user_id = #{userId}," +
            "status = #{status}" +
            "WHERE book_history_id = #{id}")
    void update(BookHistory bookHistory);

    @Delete("DELETE FROM book_history WHERE book_history_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO book_history (paper_book_id, user_id, status, created_at) " +
            "VALUES(#{paperBookId}, #{userId}, #{status}, NOW())")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "books_id",
            statement = "select currval('book_history_book_history_id_seq')",
            resultType = Integer.class)
    void insert(BookHistory bookHistory);
}
