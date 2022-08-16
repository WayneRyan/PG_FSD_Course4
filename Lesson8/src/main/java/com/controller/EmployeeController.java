package com.controller;

import com.bean.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employeeDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

    @RequestMapping(value = "storeEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String storeEmployee(@RequestBody Employee emp){
        return employeeService.storeEmployee(emp);
    }

    @RequestMapping(value = "updateSalary", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public String updateSalary(@RequestBody Employee emp){
        return employeeService.updateEmployeeSalary(emp);
    }

    @RequestMapping(value = "deleteEmployee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }
}
