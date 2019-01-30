package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Select("select * from users")
    @Results({@Result(property = "userSex", column = "user_sex", javaType = String.class),
            @Result(property = "nickName", column = "nick_name")})
    List<UserEntity> getAll();


    @Select("select * from users where id = #{id}")
    @Results({@Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")})
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName, user_sex, passWord, nick_name) VALUES (#{userName},  #{userSex}, #{passWord}, #{nickName})")
    long insert(UserEntity userEntity);

    @Update("update users set userName=#{userName},nick_name=#{nickName} where id = #{id}")
    void update(UserEntity userEntity);

    @Delete("delete from users where id = #{id}")
    void delete(Long id);


    List<UserEntity> getUserEntityList();

    UserEntity getUserEntitiyOne(Long id);
}
