package com.controller;

import com.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "checkCredentials", method = RequestMethod.POST)
    public String checkCredentials(HttpServletRequest request){
        User user = userService.checkCredentials(request.getParameter("user_name"), request.getParameter("password"));
        if (user != null) {
            request.getSession().setAttribute("login", user);
            return "homeScreen";
        } else {
            request.getSession().invalidate();
            request.setAttribute("error", "Error Logging in");
            return "index";
        }
    }

    @RequestMapping(value = "manageUsers", method = RequestMethod.GET)
    public String manageUsers(){
        return "userManagement";
    }

    @RequestMapping(value = "manageProducts", method = RequestMethod.GET)
    public String manageProducts(){
        return "productManagement";
    }

    @RequestMapping(value = "purchaseReport", method = RequestMethod.GET)
    public String purchaseReport(){
        return "purchaseReport";
    }
}
