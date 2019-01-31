package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Resource
//    private UserMapper userMapper;

    @Override
    public UserEntity getUserEntityOne(Long id) {
//        return userMapper.getOne(id);
        return null;
    }

    @Override
    public void insert(UserEntity userEntity) {

//        long insert = userMapper.insert(userEntity);
//        logger.info("插入数据 insert = "+ insert);

    }

    @Override
    public void update(UserEntity userEntity) {

//        userMapper.update(userEntity);
    }

    @Override
    public void delete(Long id) {

//        userMapper.delete(id);
    }

    @Override
    public List<UserEntity> getAll() {
//        return userMapper.getAll();
        return null;
    }

    @Override
    public List<UserEntity> getUserEntityList() {
//        return userMapper.getUserEntityList();
        return null;
    }

    @Override
    public UserEntity getUserEntitiyOne(Long id) {
//        return userMapper.getUserEntitiyOne(id);
        return null;
    }
}
