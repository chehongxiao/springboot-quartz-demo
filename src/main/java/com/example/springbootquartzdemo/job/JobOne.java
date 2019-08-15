package com.example.springbootquartzdemo.job;

import org.quartz.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component
public class JobOne implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data=context.getTrigger().getJobDataMap();
        String invokeParam =(String) data.get("invokeParam");
        //在这里实现业务逻辑
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(new Date());
        System.out.println("开始执行======================"+now+",执行参数："+invokeParam);
    }
}
