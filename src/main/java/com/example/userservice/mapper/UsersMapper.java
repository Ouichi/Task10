package com.example.userservice.mapper;

import com.example.userservice.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<User> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%', #{suffix})")
    List<User> findByNameEndingWith(String suffix);

    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%', #{suffix}) AND name LIKE CONCAT(#{prefix}, '%')")
    List<User> findByNameStartingAndEnding(String prefix, String suffix);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM users WHERE phone = #{phone}")
    Optional<User> findByPhone(String phone);

    @Insert("INSERT INTO users (name, phone) VALUES (#{name}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE users SET name = #{name},phone = #{phone} WHERE id =#{id}")
    void update(User user);

    @Update("UPDATE users SET name = #{name} WHERE id =#{id}")
    void updateName(User user);

    @Update("UPDATE users SET phone = #{phone} WHERE id =#{id}")
    void updatePhone(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(int id);
}
