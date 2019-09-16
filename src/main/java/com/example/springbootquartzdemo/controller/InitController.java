package com.example.springbootquartzdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class InitController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map){
        map.put("name","chehx");
        return "jobManager";
    }

    @RequestMapping("/index2")
    public ModelAndView index2(){
        return new ModelAndView("jobManager");
    }

    @RequestMapping("/index3")
    @ResponseBody
    public Map<String, Object> index3(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaa","AAA");
        return map;
    }
}
