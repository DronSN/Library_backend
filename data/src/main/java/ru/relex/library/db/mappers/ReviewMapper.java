package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.library.db.model.Review;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Select(
            "SELECT " +
                    "review_id AS id," +
                    "books_id, " +
                    "user_id, " +
                    "rank, " +
                    "review, " +
                    "created_at, " +
                    "updated_at " +
                    "FROM review u "
    )
    List<Review> getReviews(@Param("search") String search);

    @Select("SELECT " +
            "review_id AS id," +
            "books_id, " +
            "user_id, " +
            "rank, " +
            "review, " +
            "created_at, " +
            "updated_at " +
            "FROM review u " +
            "WHERE review_id = #{id}")
    Review findById(@Param("id") int id);

    @Update("UPDATE review " +
            "SET books_id = #{booksId}," +
            "user_id = #{userId}," +
            "rank = #{rank}," +
            "review = #{review}," +
            "updated_at = NOW() " +
            "WHERE review_id = #{id}")
    void update(Review review);

    @Delete("DELETE FROM review WHERE review_id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO review (books_id, user_id, rank, review, created_at) " +
            "VALUES(#{booksId}, #{userId}, #{rank}, #{review}, NOW())")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "review_id",
            statement = "select currval('review_review_id_seq')",
            resultType = Integer.class)
    void insert(Review review);
}
