package com.example.springbootquartzdemo.service.impl;

import com.example.springbootquartzdemo.entity.AppQuartz;
import com.example.springbootquartzdemo.service.IAppQuartzService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppQuartzService implements IAppQuartzService {
    @Override
    public void insertAppQuartzSer(AppQuartz appQuartz) {

    }

    @Override
    public List<AppQuartz> selectAppQuartzByIdSer(Integer quartzId) {
        return null;
    }

    @Override
    public void deleteAppQuartzByIdSer(Integer quartzId) {

    }

    @Override
    public void updateAppQuartzSer(AppQuartz appQuartz) {

    }
}
