package com.example.springbootquartzdemo.controller;

import com.example.springbootquartzdemo.utils.JobUtil;
import com.example.springbootquartzdemo.entity.AppQuartz;
import com.example.springbootquartzdemo.entity.ReturnMsg;
import com.example.springbootquartzdemo.service.impl.AppQuartzService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/job")
public class JobController {
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private AppQuartzService appQuartzService;


    //添加一个job
    @RequestMapping(value="/addJob",method= RequestMethod.POST)
    public ReturnMsg addjob(@RequestBody AppQuartz appQuartz) throws Exception {
        appQuartzService.insertAppQuartzSer(appQuartz);
        String ret=jobUtil.addJob(appQuartz);
        if("success".equals(ret)) {
            return new ReturnMsg("200","success addjob",ret);
        }else {
            return new ReturnMsg("404","fail addjob",ret);
        }
    }

    //暂停job
    @RequestMapping(value="/pauseJob",method=RequestMethod.POST)
    public ReturnMsg pausejob(@RequestBody Integer[]quartzIds) throws Exception {
        AppQuartz appQuartz=null;
        if(quartzIds.length>0){
            for(Integer quartzId:quartzIds) {
                appQuartz=appQuartzService.selectAppQuartzByIdSer(quartzId).get(0);
                jobUtil.pauseJob(appQuartz.getJobName(), appQuartz.getJobGroup());
                appQuartz.setState("0");
                appQuartzService.updateAppQuartzStateSer(appQuartz);
            }
            return new ReturnMsg("200","success pauseJob");
        }else {
            return new ReturnMsg("404","fail pauseJob");
        }
    }

    //恢复job
    @RequestMapping(value="/resumeJob",method=RequestMethod.POST)
    public ReturnMsg resumejob(@RequestBody Integer[]quartzIds) throws Exception {
        AppQuartz appQuartz=null;
        if(quartzIds.length>0) {
            for(Integer quartzId:quartzIds) {
                appQuartz=appQuartzService.selectAppQuartzByIdSer(quartzId).get(0);
                jobUtil.resumeJob(appQuartz.getJobName(), appQuartz.getJobGroup());
                appQuartz.setState("1");
                appQuartzService.updateAppQuartzStateSer(appQuartz);
            }
            return new ReturnMsg("200","success resumeJob");
        }else {
            return new ReturnMsg("404","fail resumeJob");
        }
    }


    //删除job
    @RequestMapping(value="/deletejob",method=RequestMethod.POST)
    public ReturnMsg deletejob(@RequestBody Integer[]quartzIds) throws Exception {
        AppQuartz appQuartz=null;
        for(Integer quartzId:quartzIds) {
            appQuartz=appQuartzService.selectAppQuartzByIdSer(quartzId).get(0);
            String ret=jobUtil.deleteJob(appQuartz);
            if("success".equals(ret)) {
                appQuartzService.deleteAppQuartzByIdSer(quartzId);
            }
        }
        return new ReturnMsg("200","success deleteJob");
    }

    //修改
    @RequestMapping(value="/updateJob",method=RequestMethod.POST)
    public ReturnMsg  modifyJob(@RequestBody AppQuartz appQuartz) throws Exception {
        String ret= jobUtil.modifyJob(appQuartz);
        if("success".equals(ret)) {
            appQuartzService.updateAppQuartzSer(appQuartz);
            return new ReturnMsg("200","success updateJob",ret);
        }else {
            return new ReturnMsg("404","fail updateJob",ret);
        }
    }

    //暂停所有
    @RequestMapping(value="/pauseAll",method=RequestMethod.GET)
    public ReturnMsg pauseAllJob() throws Exception {
        jobUtil.pauseAllJob();
        return new ReturnMsg("200","success pauseAll");
    }

    //恢复所有
    @RequestMapping(value="/repauseAll",method=RequestMethod.GET)
    public ReturnMsg repauseAllJob() throws Exception {
        jobUtil.resumeAllJob();
        return new ReturnMsg("200","success repauseAll");
    }

    //查看状态
    @RequestMapping(value="/getJobState",method=RequestMethod.GET)
    public String getJobState(@RequestParam String jobName, @RequestParam String jobGroup) throws Exception {
        return jobUtil.getJobState(jobName,jobGroup);
    }

    @RequestMapping(value="/queryjob",method=RequestMethod.GET)
    public Map<String, Object> queryjob(@RequestParam(value="pageNum")Integer pageNum, @RequestParam(value="pageSize")Integer pageSize)
    {
        PageInfo<AppQuartz> job = appQuartzService.selectAppQuartzByPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("job", job);
        map.put("number", job.getTotal());
        return map;
    }

}
