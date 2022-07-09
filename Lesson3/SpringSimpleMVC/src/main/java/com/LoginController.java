package com;

import com.bean.Login;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public ModelAndView checkUserDetails(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ModelAndView mav = new ModelAndView();
        if(email.equals("wryan@gmail.com") && password.equals("123")){
            mav.setViewName("success.jsp");
        } else {
            mav.setViewName("failure.jsp");
        }
        return mav;
    }

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signIn(HttpServletRequest req, Login ll) {
        ll.setEmail(req.getParameter("email"));
        ll.setPassword(req.getParameter("password"));
        String result = loginService.signIn(ll);
        ModelAndView mav = new ModelAndView();
        if(result.equals("success")){
            mav.setViewName("success.jsp");
        } else {
            mav.setViewName("failure.jsp");
        }
        return mav;
    }
    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUp(HttpServletRequest req, Login ll) {
        ll.setEmail(req.getParameter("email"));
        ll.setPassword(req.getParameter("password"));
        String result = loginService.signUp(ll);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login.jsp");
        mav.addObject("msg", result); // model scope is equal to request.setAttribute("msg", result);
        return mav;
    }
}
