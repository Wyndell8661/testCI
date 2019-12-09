package com.example.demo.controllers;

import com.alibaba.fastjson.JSON;
import com.example.demo.entities.Systems;
import com.example.demo.services.ServiceInterface;
import com.example.demo.services.SystemService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemsController {

    private static Logger logger = LoggerFactory.getLogger(SystemsController.class);

    @Autowired
    public SystemService systemService;

    @Autowired
    @Qualifier("service2")
    public ServiceInterface serviceInterface;

    @RequestMapping("listsystems")
    public List listSystems(HttpServletRequest request, @RequestParam("currentpage") Integer currentPage, @RequestParam("pagesize") Integer pageSize){
        //设置的是当前的页数和每页显示的数量（必须写在查询之前）；
        PageHelper.startPage(currentPage,pageSize);
        //这时候查出来的就是分过页之后的list了；
        List<Systems> systemsList = systemService.getAllSystems();
        System.out.println("request is:"+request);
        System.out.println("session is:"+request.getSession());
        return systemsList;
    }

    @RequestMapping("hello")
    public String hello(HttpSession session){
        System.out.println(session.getId());
        System.out.println("session is:"+session);
        System.out.println(session.getAttribute("name"));
        return "hello888";
    }

    @PostMapping("hello1")
    public String hello1(@RequestBody String body,HttpSession session) throws Exception {
        session.setAttribute("name","jinwenpeng");
        return body;
    }

    @GetMapping("hello3")
    public String hello3(){
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
        return "hello!";
    }

    //@ResponseStatus(code = HttpStatus.TOO_MANY_REQUESTS,reason = "you hava requested too frequently")
    @RequestMapping("hello2")
    public String hello2(HttpSession session) throws Exception {
        //int a = 1/0;
        System.out.println(session);
        System.out.println("进入方法hello2");
        return "hello";
    }

    @GetMapping("hello4")
    public Map<String,Object> hello4(){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success",true);
        resultMap.put("message",null);
        resultMap.put("requestId", MDC.get("requestId"));
        Systems systems = new Systems();
        systems.setIp("192.18.2.1");
        systems.setSystemName("短信中心");
        resultMap.put("result", JSON.toJSON(systems));
        logger.info("收到请求...");
        return resultMap;
    }

}
