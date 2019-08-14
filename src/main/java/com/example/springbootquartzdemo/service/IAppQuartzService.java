package com.example.springbootquartzdemo.service;

import com.example.springbootquartzdemo.entity.AppQuartz;

import java.util.List;

public interface IAppQuartzService {
    void insertAppQuartzSer(AppQuartz appQuartz);
    List<AppQuartz> selectAppQuartzByIdSer(Integer quartzId);
    void deleteAppQuartzByIdSer(Integer quartzId);
    void updateAppQuartzSer(AppQuartz appQuartz);
}
