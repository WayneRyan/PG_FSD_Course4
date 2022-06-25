package com.bean;

public class Employee {
    private int id;
    private String name;
    private float salary;

    public Employee(){
        System.out.println("Object created...");
    }

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("This is employee class.");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
