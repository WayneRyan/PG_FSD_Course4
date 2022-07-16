package com.controller;

import com.bean.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    @RequestMapping(value = "/")
    public String sayHello(){
        return "Welcome to Spring boot with Rest full web service";
    }

    @RequestMapping(value = "/plain", produces = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.GET)
    public String sayPlainText(){
        return "<h1>Welcome to spring boot</h1>";
    }

    @RequestMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public String sayHTMLText(){
        return "<h1>Welcome to spring boot</h1>";
    }
    @RequestMapping(value = "/xml", produces = MediaType.TEXT_XML_VALUE)
    public String sayXMLText(){
        return "<h1>Welcome to spring boot</h1>";
    }

    @RequestMapping(value = "empInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeInfo() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Bob");
        emp.setSalary(14000);
        return emp;
    }

    @RequestMapping(value = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployeeInfo() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Bob");
        emp.setSalary(14000);
        employeeList.add(emp);
        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Jack");
        emp2.setSalary(24000);
        employeeList.add(emp);
        return employeeList;
    }

    @RequestMapping(value = "singleQuery")
    public String singleQueryValue(@RequestParam("name") String name) {
        return "Welcome Spring boot with query param concept "+name;

    }

    @RequestMapping(value = "pathValue/{name}")
    public String singlePathValue(@PathVariable("name")Integer fname){
        return "Welsome to Spring boot with path param concept " + fname;
    }

    @RequestMapping(value = "postMethod", method = RequestMethod.POST)
    public String simplePostMethod() {
        return "Welcome to Post method";
    }

    // http://localhost:8080/storeEmployee  through body part {"id":100,"name":"Bob","salary":15000}
    @RequestMapping(value = "storeEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String storeEmployee(@RequestBody Employee emp) {
        System.out.println(emp);
        return "Got your request";
    }

    @RequestMapping(value = "updateEmployee",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@RequestBody Employee emp) {
        System.out.println(emp);
        emp.setSalary(emp.getSalary() + 500);
        return emp;
    }

    @RequestMapping(value = "deleteEmployee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployeeInfo(@PathVariable("id") int id){
        return "Employee details with id " + id + " deleted successfully";
    }
}
