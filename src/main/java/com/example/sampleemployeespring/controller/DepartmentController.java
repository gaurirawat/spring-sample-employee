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

    @PostMapping("/create/{id}")
    public Department createDept(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/delete/{id}")
    public void deleteDept(@PathVariable(value = "id") Integer id) {
        departmentRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Department updateCabin(@PathVariable("id") Integer id, @Valid @RequestBody Department cabin){
//        Cabin cabin1 =cabinRepository.getOne(id);
//        cabin1.setEmployee(cabin.getEmployee());
//        cabin1.setFloorNo(cabin.getFloorNo());
//        cabin1.setRoomNo(cabin.getRoomNo());
        return departmentRepository.save(cabin);
    }

}

