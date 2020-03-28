package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.repository.*;
import com.example.sampleemployeespring.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("project/")
public class ProjectController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;


    @PutMapping("/test/{id}")
    public Project test(@PathVariable ("id")Integer id) {
        Project d1= projectRepository.getOne(id);
        d1.setGuide("biotechhhhh");
        d1.setProjectName("sacfsa");
        return projectRepository.save(d1);
    }

    @GetMapping("/getAll")
    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Project getProjectById(@PathVariable(value="id") Integer id){
        return projectRepository.getOne(id);
    }

    @PostMapping("/create/{empId}")
    public Project createProject(@PathVariable("empId") Integer id, @Valid @RequestBody Project project){
        project.setEmployee(employeeRepository.getOne(id));
        return projectRepository.save(project);
    }

    @PutMapping("/delete/{id}")
    public void deleteProject(@PathVariable("id") Integer id){
        projectRepository.deleteById(id);
    }
}
