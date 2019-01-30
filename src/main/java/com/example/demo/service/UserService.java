package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getUserEntityOne(Long id);

    void insert(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(Long id);

    List<UserEntity> getAll();

    List<UserEntity> getUserEntityList();

    UserEntity getUserEntitiyOne(Long id);
}
