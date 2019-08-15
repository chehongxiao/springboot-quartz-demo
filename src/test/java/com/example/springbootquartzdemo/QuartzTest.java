package com.example.springbootquartzdemo;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootQuartzDemoApplication.class, MockServletContext.class})
public class QuartzTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAddJob() {
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("jobName","testJob");
        paramsMap.put("jobGroup","JobOne");
        paramsMap.put("startTime","2019-08-15 10:00:00");
        paramsMap.put("cronExpression","0/1 * * * * ? *");
        paramsMap.put("invokeParam","param");
        final String param = JSON.toJSONString(paramsMap);
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/addJob").contentType(MediaType.APPLICATION_JSON).content(param))
                    .andReturn();
            LOGGER.info(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllCategoryTest() throws Exception {
        String responseString = mockMvc.perform(
                get("/pauseAll")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("pcode","root")
        ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }


}
