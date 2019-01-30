package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count = 0;

    /**
     * 定时任务
     * 每隔6秒执行
     */
//    @Scheduled(fixedRate = 1000)
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
