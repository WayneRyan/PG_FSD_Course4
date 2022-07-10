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

    @RequestMapping(value = "editUser", method = RequestMethod.POST)
    public ModelAndView editUser(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user.setUser_id(request.getParameter("user_id"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        if (userService.updateUser(user)){
            mav.addObject("msg", "User successfully updated");
        } else {
            mav.addObject("msg", "Something went wrong");
        }
        mav.setViewName("index.jsp");
        return mav;
    }
}
