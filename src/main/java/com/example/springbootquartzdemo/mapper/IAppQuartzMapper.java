package com.example.springbootquartzdemo.mapper;

import com.example.springbootquartzdemo.entity.AppQuartz;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "appQuartzMapper")
public interface IAppQuartzMapper {

    @Insert("INSERT INTO app_quartz (job_name, job_group, start_time, cron_expression, invoke_param, state) VALUES (#{jobName}, #{jobGroup}, #{startTime}, #{cronExpression}, #{invokeParam}, '1')")
    void insertAppQuartz(AppQuartz appQuartz);

    @Select("SELECT t.quartz_id as quartzId,t.job_name as jobName,t.job_group as jobGroup,t.cron_expression as cronExpression,t.invoke_param as invokeParam,t.state FROM app_quartz t where t.quartz_id=#{id}")
    List<AppQuartz> selectAppQuartzById(Integer quartzId);

    @Delete("DELETE FROM app_quartz where quartz_id =#{id}")
    void deleteAppQuartzById(Integer quartzId);

    @Update("UPDATE app_quartz t set t.start_time=#{startTime}, t.cron_expression=#{cronExpression},t.invoke_param=#{invokeParam},t.job_group=#{jobGroup},t.job_name=#{jobName} WHERE t.quartz_id=#{quartzId}")
    void updateAppQuartz(AppQuartz appQuartz);

    @Select("SELECT t.quartz_id as quartzId,t.job_name as jobName,t.job_group as jobGroup,t.cron_expression as cronExpression,t.invoke_param as invokeParam,t.start_time as startTime,t.state FROM app_quartz t")
    List<AppQuartz> selectAllAppQuartz();

    @Update("UPDATE app_quartz t set t.state=#{state} WHERE t.quartz_id=#{quartzId}")
    void updateAppQuartzState(AppQuartz appQuartz);
}
