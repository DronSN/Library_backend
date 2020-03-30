package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.WaitList;

import java.util.List;

@Mapper
public interface WaitListMapper {

    @Select(
            "SELECT " +
                    "wait_list_id AS id," +
                    "books_id, " +
                    "user_id, " +
                    "created_at " +
                    "FROM wait_list u "
    )
    List<WaitList> getWaitLists();

    @Select("SELECT " +
            "wait_list_id AS id," +
            "books_id, " +
            "user_id, " +
            "created_at " +
            "FROM wait_list u " +
            "WHERE wait_list_id = #{id}")
    WaitList findById(@Param("id") int id);

    @Update("UPDATE wait_list " +
            "SET books_id = #{booksId}," +
            "user_id = #{userId}," +
            "created_at = NOW()" +
            "WHERE wait_list_id = #{id}")
    void update(WaitList waitList);

    @Delete("DELETE FROM wait_list WHERE wait_list_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO wait_list (books_id, user_id, created_at) " +
            "VALUES(#{booksId}, #{userId}, NOW())")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "wait_list_id",
            statement = "select currval('wait_list_wait_list_id_seq')",
            resultType = Integer.class)
    void insert(WaitList waitList);
}
