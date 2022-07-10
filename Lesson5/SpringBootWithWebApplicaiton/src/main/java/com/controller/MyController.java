package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping(value = "abc")
    public String openDemo1Page(){
        return "demo1";
    }

    @RequestMapping(value = "xyz")
    public String openDemo2Page(){
        return "demo2";
    }

    @RequestMapping(value = "login")
    public String openLoginPage(){
        return "login";
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public String checkUserDetails(HttpServletRequest req){
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if(email.equals("wryan@gmail.com") && password.equals("abc")){
            return "success";
        } else {
            return "failure";
        }
    }
}
