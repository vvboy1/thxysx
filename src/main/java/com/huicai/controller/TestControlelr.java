package com.huicai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huicai.pojo.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestControlelr {
    //配置 controller的请求路径
    @RequestMapping("/test1")
    public String test1(){
        System.out.println("访问了服务器");
        //实际是跳转  success.jsp
        return "success";
    }

    @RequestMapping("/test2")
    public String test2(@RequestParam("name") String userName, int age){
        System.out.println(userName+age);
        return "success";
    }
    @RequestMapping("/test3")
    public String test3(TestUser user){
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping("/test4")
    public String test4(TestUser user){
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping(value = "/test5",produces = "text/html;charset=utf-8")
    //说明 返回的是 Json数据 而不是 进行页面跳转     返回json字符串
    @ResponseBody
    public String test5(TestUser user) throws JsonProcessingException {
        //返回json字符串  手写 json
        //return "{\"name\":\""+user.getName()+"\",\"age\":\"26\"}";
        // 通过json转换器转换
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);

    }
    //返回json格式 对象
    @RequestMapping("/test6")
    @ResponseBody //返回Json对象
    //将Json数据 转换为 java对象
    public TestUser test6(@RequestBody TestUser user){
        System.out.println(user.toString());
        user.setName("罗媛媛");
        return user;
    }

    @RequestMapping("/test7")
    @ResponseBody
    public Map test7(TestUser user){
        System.out.println(user.toString());
        //特点：  key,value   json格式 {"key","value"}
        Map result = new HashMap();
        result.put("success","true");
        result.put("message","数据交互成功");
        return  result;
    }

}
