package com.example.springbootquartzdemo.service.impl;

import com.example.springbootquartzdemo.entity.AppQuartz;
import com.example.springbootquartzdemo.mapper.IAppQuartzMapper;
import com.example.springbootquartzdemo.service.IAppQuartzService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppQuartzService implements IAppQuartzService {

    @Autowired
    private IAppQuartzMapper appQuartzMapper;

    @Override
    public void insertAppQuartzSer(AppQuartz appQuartz) {
        appQuartzMapper.insertAppQuartz(appQuartz);
    }

    @Override
    public List<AppQuartz> selectAppQuartzByIdSer(Integer quartzId) {
        List<AppQuartz> appQuartzs = appQuartzMapper.selectAppQuartzById(quartzId);
        return appQuartzs;
    }

    @Override
    public void deleteAppQuartzByIdSer(Integer quartzId) {
        appQuartzMapper.deleteAppQuartzById(quartzId);
    }

    @Override
    public void updateAppQuartzSer(AppQuartz appQuartz) {
        appQuartzMapper.updateAppQuartz(appQuartz);
    }

    @Override
    public PageInfo<AppQuartz> selectAppQuartzByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AppQuartz> appQuartzs = appQuartzMapper.selectAllAppQuartz();
        PageInfo<AppQuartz> page = new PageInfo<AppQuartz>(appQuartzs);
        return page;
    }

}
