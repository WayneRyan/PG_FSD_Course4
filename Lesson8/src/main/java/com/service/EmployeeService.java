package com.service;

import com.bean.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public String storeEmployee(Employee emp){
        Optional<Employee> e = employeeRepository.findById(emp.getId());
        if (e.isPresent()){
            return "Employee already exists.";
        } else {
            employeeRepository.save(emp);
            return "Employee saved";
        }
    }

    public String updateEmployeeSalary(Employee emp) {
        Optional<Employee> e = employeeRepository.findById(emp.getId());
        if (e.isPresent()) {
            Employee employee = e.get();
            employee.setSalary(emp.getSalary());
            employeeRepository.saveAndFlush(employee);
            return "Eployee salary update successfully";
        }else {
            return "Employe not in database.";
        }
    }

    public String deleteEmployee(int id) {
        Optional<Employee> e = employeeRepository.findById(id);
        if (e.isPresent()) {
            Employee employee = e.get();
            employeeRepository.delete(employee);
            return "Employee deleted from database";
        }else {
            return "Employe not in database.";
        }

    }
}
