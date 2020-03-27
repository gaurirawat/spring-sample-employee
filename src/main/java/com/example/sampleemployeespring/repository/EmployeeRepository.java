package com.example.sampleemployeespring.repository;


import com.example.sampleemployeespring.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
