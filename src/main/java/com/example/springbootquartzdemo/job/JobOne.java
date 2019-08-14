package com.example.springbootquartzdemo.job;

import org.quartz.*;
import org.springframework.stereotype.Component;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component
public class JobOne implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data=context.getTrigger().getJobDataMap();
        String invokeParam =(String) data.get("invokeParam");
        //在这里实现业务逻辑
    }
}
