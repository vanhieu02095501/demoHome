package com.fsofter.home.repository;

import com.fsofter.home.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE username = #{username}")
    @ResultMap("userMap")
    User findByUsername(@Param("username") String username);

    @Select("SELECT * FROM users")
    @ResultMap("userMap")
    List<User> findAllUsers();

    @Insert("INSERT INTO users (username, password, role) VALUES (#{username}, #{password}, #{role})")
    void insertUser(User user);

    @Results(id = "userMap", value = {
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    @Select("SELECT * FROM users WHERE role = #{role}")
    List<User> findByRole(@Param("role") String role);
}
