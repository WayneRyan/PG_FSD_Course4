package com;

public class Operation {

    public int add(int a, int b) {
        int sum = a-b;
        return sum;
    }

    public Employee getEmployeeDetails(){
        Employee emp = new Employee();
        emp.setId(5);
        emp.setName("Bob");
        emp.setSalary(500);
        return emp;
    }


}
