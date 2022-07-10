package com.service;

import com.bean.Employee;
import com.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public String storeEmployee(Employee emp) {
        if (emp.getSalary() < 10000) {
            return "Salary must be > 10,000";
        } else if (employeeDao.storeEmployeeDetails(emp) > 0) {
            return "Record inserted successfully";
        } else {
            return "Record didn't insert";
        }
    }

    public String incrementSalary(Employee emp) {
        float oldSalary = employeeDao.findEmployeeSalary(emp.getId());
        if (oldSalary == 0) {
            return "Employee does not exist";
        }
        if (emp.getSalary() > oldSalary) {
            if (employeeDao.updateSalary(emp) > 0) {
                return "Salary incremented successfully";
            } else {
                return "Salary didn't update";
            }
        } else {
            return "Salary didn't update";
        }
    }
}
