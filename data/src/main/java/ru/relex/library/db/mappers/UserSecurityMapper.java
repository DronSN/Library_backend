package ru.relex.library.db.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.relex.library.db.model.SecurityUserDetails;

@Mapper
public interface UserSecurityMapper {
    @Select(
            //language=PostgreSQL
            "SELECT " +
                    "user_id AS id," +
                    "username, " +
                    "password, " +
                    "role_id as role " +
                    "FROM users u " +
                    "WHERE username = #{username:VARCHAR} "
    )
    SecurityUserDetails findUserByUsername(@Param("username") String username);
}
