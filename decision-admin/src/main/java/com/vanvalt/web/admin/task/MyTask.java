package com.vanvalt.web.admin.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  
public class MyTask {  
    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行  
    public void taskCycle(){  
        System.out.println("无主题(www.wuzhuti.cn) ");  
    }  
}  
