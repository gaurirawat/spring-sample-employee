package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.repository.*;
import com.example.sampleemployeespring.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CabinRepository cabinRepository;

    @GetMapping("/getAll")
    public List<Employee> getEmp(){
        return employeeRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Employee getEmpById(@PathVariable(value=  "id") Integer id){
        return employeeRepository.getOne(id);
    }

    @PostMapping("/create/{cabinId}")
    public Employee createEmp(@PathVariable("cabinId") Integer id, @Valid @RequestBody Employee employee){
        employee.setCabin(cabinRepository.getOne(id));
        return employeeRepository.save(employee);
    }

    @PutMapping("/delete/{id}")
    public void deleteEmp(@PathVariable("id") Integer id){
        employeeRepository.deleteById(id);
    }
}