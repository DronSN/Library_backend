package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.Plan;

import java.util.List;

public interface PlanMapper {
    @Select(
            "SELECT " +
                    "plan_id AS id," +
                    "books_id, " +
                    "user_id, " +
                    "page_goal, " +
                    "date_goal " +
                    "FROM plan u "
    )
    List<Plan> getPlans(@Param("search") String search);

    @Select("SELECT " +
            "plan_id AS id," +
            "books_id, " +
            "user_id, " +
            "page_goal, " +
            "date_goal " +
            "FROM plan u " +
            "WHERE plan_id = #{id}")
    Plan findById(@Param("id") int id);

    @Update("UPDATE plan " +
            "SET books_id = #{booksId}," +
            "user_id = #{userId}," +
            "page_goal = #{pageGoal}," +
            "date_goal = #{dateGoal} " +
            "WHERE plan_id = #{id}")
    void update(Plan plan);

    @Delete("DELETE FROM plan WHERE plan_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO plan (books_id, user_id, page_goal, date_goal) " +
            "VALUES(#{booksId}, #{userId}, #{pageGoal}, #{dateGoal})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "plan_id",
            statement = "select currval('plan_plan_id_seq')",
            resultType = Integer.class)
    void insert(Plan plan);
}
