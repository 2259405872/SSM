package com.ys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

//@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
@RequestMapping("/test")
public class RequestMappingController {

    //@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
    @RequestMapping("/hello")
    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    public String testLocation(){
        return "success";
    }

    @RequestMapping(value ={"hello1","hello2"})
    /*
    @RequestMapping注解的value属性通过请求的请求地址匹配请求映射
    @RequestMapping注解的value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址
    所对应的请求
    @RequestMapping注解的value属性必须设置，至少通过请求地址匹配请求映射
    */
    public String testValue(){
        return "success";
    }

    @RequestMapping(
            value = "testMethod"
            ,method = {RequestMethod.GET,RequestMethod.POST}
    )
    /*
    @RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射
    当没有设置method时，则所有请求都可以通过
    @RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配
    多种请求方式的请求
    若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错
    405：Request method 'POST' not supported
    */
    public String testMethod(){
        return "success";
    }

    @RequestMapping(
            value = "testParams",
            params = {
                    "username",
                    "password!=123456",
                    "!age"
            }
    )
    /*
        @RequestMapping注解的params属性通过请求的请求参数匹配请求映射
        @RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系
        "param"：要求请求映射所匹配的请求必须携带param请求参数
        "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
        "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
        "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
    */
    public String testPrams(){
        return "success";
    }
    @RequestMapping( "/a?t/a*t1/**/")
//    3.7、SpringMVC支持ant风格的路径
//    ？：表示任意的单个字符
//    *：表示任意的0个或多个字符
//    **：表示任意层数的任意目录
//    注意：在使用**时，只能使用/**/xxx的方式
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
/*

    原始方式：/deleteUser?id=1
    rest方式：/user/delete/1
    SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服
    务器中，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在
    通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
*/
    public String testRest(@PathVariable("id") String id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
