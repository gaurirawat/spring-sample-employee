package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.repository.*;
import com.example.sampleemployeespring.beans.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("emp/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CabinRepository cabinRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/getAll")
    public List<Employee> getEmp() {
        List<Employee> list = employeeRepository.findAll();
        Collections.sort(list);
        return list;
    }

    @GetMapping("/getOne/{id}")
    public Employee getEmpById(@PathVariable(value = "id") Integer id) {
        return employeeRepository.getOne(id);
    }

    @PostMapping("/create/{cabinId}/{deptId}")
    public Employee createEmp(@PathVariable("cabinId") Integer idC, @PathVariable("deptId") Integer idD, @Valid @RequestBody Employee employee) {
        employee.setCabin(cabinRepository.getOne(idC));
        employee.setDepartment(departmentRepository.getOne(idD));
        return employeeRepository.save(employee);
    }

    @PutMapping("/delete/{id}")
    public void deleteEmp(@PathVariable("id") Integer id) {
        employeeRepository.deleteById(id);
    }
//---------------------------------------------------------------------


    @PostMapping("/test")
    public String jsonServiceTestFunc(@RequestBody @Valid String jsonString) throws JsonProcessingException {
        List<Employee> list = employeeRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonStringy = mapper.writerWithDefaultPrettyPrinter().withRootName("employees").writeValueAsString(list);
        list = (new JsonService<Employee>()).fromJsonList(jsonStringy, "employees", Employee.class);
        System.out.println(list.get(0));
        Employee employee = list.get(0);
        System.out.println(employee.getName());
        return "ok";
    }

    @GetMapping("create")
    public String getJsonString(){
        Gson gson = new Gson();
        List<Employee> list = employeeRepository.findAll();
        String jsonCartList = gson.toJson(list);
        System.out.println(gson);
        return jsonCartList;
    }


}
