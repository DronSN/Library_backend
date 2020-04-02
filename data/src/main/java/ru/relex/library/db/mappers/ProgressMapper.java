package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.Progress;

import java.util.List;

public interface ProgressMapper {

    @Select(
            "SELECT " +
                    "progress_id AS id," +
                    "books_id, " +
                    "user_id, " +
                    "page_got, " +
                    "created_at " +
                    "FROM progress u "
    )
    List<Progress> getProgress(@Param("search") String search);

    @Select("SELECT " +
            "progress_id AS id," +
            "books_id, " +
            "user_id, " +
            "page_got, " +
            "created_at " +
            "FROM progress u " +
            "WHERE progress_id = #{id}")
    Progress findById(@Param("id") int id);

    @Delete("DELETE FROM progress WHERE progress_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO progress (books_id, user_id, page_got, created_at) " +
            "VALUES(#{booksId}, #{userId}, #{pageGot}, NOW())")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "progress_id",
            statement = "select currval('progress_progress_id_seq')",
            resultType = Integer.class)
    void insert(Progress progress);
}
