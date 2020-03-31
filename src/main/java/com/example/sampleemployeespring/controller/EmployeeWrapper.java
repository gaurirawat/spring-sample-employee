package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.beans.Employee;

import java.util.List;

public class EmployeeWrapper {
    List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
