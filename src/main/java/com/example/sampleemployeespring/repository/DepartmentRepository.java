package com.example.sampleemployeespring.repository;

import com.example.sampleemployeespring.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
