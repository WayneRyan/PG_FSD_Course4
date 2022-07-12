package com.controller;

import com.bean.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "storeEmployee", method = RequestMethod.GET)
    public String storeEmployeePage() {
        return "storeEmployee";
    }

    @RequestMapping(value = "storeEmployee", method = RequestMethod.POST)
    public String storeEmployee(HttpServletRequest request, Employee employee) {
        employee.setSalary(Float.parseFloat(request.getParameter("employee_salary")));
        employee.setName(request.getParameter("employee_name"));
        employee.setId(Integer.parseInt(request.getParameter("employee_id")));
        String result = employeeService.storeEmployee(employee);
        request.setAttribute("msg", result);
        return "index";
    }

    @RequestMapping(value = "updateEmployee", method = RequestMethod.GET)
    public String updateEmployee() {
        return "updateEmployee";
    }

    @RequestMapping(value = "updateSalary", method = RequestMethod.POST)
    public String updateEmployeeSalary(HttpServletRequest request, Employee employee) {
        employee.setSalary(Float.parseFloat(request.getParameter("employee_salary")));
        employee.setId(Integer.parseInt(request.getParameter("employee_id")));
        String result = employeeService.incrementSalary(employee);
        request.setAttribute("msg", result);
        return "index";
    }

    @RequestMapping(value = "deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(){
        return "deleteEmployee";
    }

    @RequestMapping(value = "deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String result = employeeService.deleteEmployeeRecord(id);
        request.setAttribute("msg", result);
        return "index";
    }

    @RequestMapping(value = "getAllEmployees", method = RequestMethod.GET)
    public String getAllEmployees(HttpServletRequest request){
        System.out.println("hello world");
        request.setAttribute("allEmployees", employeeService.getAllEmployees());
        System.out.println("hello world");
        return "allEmployees";
    }
}
