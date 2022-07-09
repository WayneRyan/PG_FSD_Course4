package com.controller;

import com.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "selectUser", method = RequestMethod.POST)
    public ModelAndView selectUser(HttpServletRequest request) {
        String user_id = request.getParameter("user_id");
        ModelAndView mav = new ModelAndView();
        User user = userService.getUser(user_id);
        if (user == null){
            mav.addObject("msg","User not found");
            mav.setViewName("index.jsp");
        } else {
            mav.addObject("user", user);
            mav.setViewName("editUser.jsp");
        }
        return mav;
    }
}
