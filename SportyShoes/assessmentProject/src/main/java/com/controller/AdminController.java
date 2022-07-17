package com.controller;

import com.bean.Category;
import com.bean.Product;
import com.bean.User;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "checkCredentials", method = RequestMethod.POST)
    public String checkCredentials(HttpServletRequest request) {
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

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping(value = "homeScreen", method = RequestMethod.GET)
    public String homeScreen() {
        return "homeScreen";
    }

    @RequestMapping(value = "manageUsers", method = RequestMethod.GET)
    public String manageUsers(HttpServletRequest request) {
        request.getSession().setAttribute("listOfUsers", userService.getAllUsers());
        return "userManagement";
    }

    @RequestMapping(value = "searchUsers", method = RequestMethod.POST)
    public String searchUsers(HttpServletRequest request) {
        request.getSession().setAttribute("listOfUsers", userService.getFilteredUsers(request.getParameter("filterText")));
        return "userManagement";
    }

    @RequestMapping(value = "manageProducts", method = RequestMethod.GET)
    public String manageProducts(HttpServletRequest request) {
        List<Product> productList = productService.getAllProducts();
        request.getSession().setAttribute("listOfProducts", productList);
        request.getSession().setAttribute("listOfCategories", categoryService.getAllCategories());
        if (productList.size() > 0) {
            request.getSession().setAttribute("selectedProduct", productList.get(0));
        }
        return "productManagement";
    }

    @RequestMapping(value = "purchaseReport", method = RequestMethod.GET)
    public String purchaseReport() {
        return "purchaseReport";
    }

    @RequestMapping(value = "selectProduct", method = RequestMethod.GET)
    public String selectProduct(HttpServletRequest request) {
        int selectedProduct = Integer.parseInt(request.getParameter("selectedProduct"));
        request.getSession().setAttribute("selectedProduct", productService.getProduct(selectedProduct));
        return "productManagement";
    }

    @RequestMapping(value = "assignCategory", method = RequestMethod.POST)
    public String assignCategory(HttpServletRequest request) {
        Product selectedProduct = productService.getProduct(Integer.parseInt(request.getParameter("selectedProduct")));
        Category selectedCategory = categoryService.getCategory(Integer.parseInt(request.getParameter("selectedCategory")));
        selectedProduct.setCategory(selectedCategory);
        productService.update(selectedProduct);
        request.getSession().setAttribute("selectedProduct", selectedProduct);
        return "productManagement";
    }
}
