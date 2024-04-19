package com.example.userservice;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM users")
    List<User>findAll();

    @Select("SELECT * FROM users WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<User> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%', #{suffix})")
    List<User> findByNameEndingWith(String suffix);

    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%', #{suffix}) AND name LIKE CONCAT(#{prefix}, '%')")
    List<User> findByNameStartingAndEnding(String prefix, String suffix);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User>findById(int id);

    @Insert("INSERT INTO users (name, phone) VALUES (#{name}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
}
