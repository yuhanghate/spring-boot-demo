package com.example.demo.controller;

import com.example.demo.bean.config.MyProps;
import com.example.demo.domain.LearnResouce;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyProps myProps;

    @Value("${name}")
    private String name;

    @Value("${content}")
    private String content;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",  method = RequestMethod.GET)
    public String login() {
        return name + " >>>>>>>bbbbb, " + content + myProps.getSimpleProp()+ myProps.getMapProps().toString()+ myProps+ myProps.getListProp1().toString();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        List<LearnResouce> learnList =new ArrayList<LearnResouce>();
        LearnResouce bean =new LearnResouce("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new LearnResouce("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new LearnResouce("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new LearnResouce("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new LearnResouce("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new LearnResouce("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    @GetMapping("/entity/one")
    public UserEntity getUserEntityOne() {
        return userService.getUserEntityOne(1L);
    }

    @GetMapping("/insert/entity")
    public void insert() {

        UserEntity userEntity = new UserEntity();

        userEntity.setNickName("yuhang"+ System.currentTimeMillis());
        userEntity.setUserSex("sex"+ System.currentTimeMillis());
        userEntity.setPassWord("password"+System.currentTimeMillis());
        userEntity.setUserName("user_name"+System.currentTimeMillis());
        userService.insert(userEntity);
    }

    @GetMapping("/find/entity")
    public List<UserEntity> getUserEntityAll() {
        return userService.getAll();
    }

    @GetMapping("find/entity/list")
    public List<UserEntity> getUserEntityList() {
        return userService.getUserEntityList();
    }

    @GetMapping("find/entity/one")
    public UserEntity getUserEntityOne2() {
        return userService.getUserEntitiyOne(2L);
    }

    @GetMapping("open/test1")
    public UserEntity getUserEntityOne3() {
        return userService.getUserEntityOne(2L);
    }
}
