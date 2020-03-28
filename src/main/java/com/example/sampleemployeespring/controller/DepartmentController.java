package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.pojo.Department;
import com.example.sampleemployeespring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("dept")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/getAll")
    public List<Department> getDept() {
        return departmentRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Department getDeptById(@PathVariable(value = "id") Integer id) {
        return departmentRepository.getOne(id);
    }

    @PostMapping("/create")
    public Department createDept(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/delete/{id}")
    public void deleteDept(@PathVariable(value = "id") Integer id) {
        departmentRepository.deleteById(id);
    }
}

