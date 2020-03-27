package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.repository.*;
import com.example.sampleemployeespring.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cabin/")
public class CabinController {
    @Autowired
    CabinRepository cabinRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Cabin> getCabins(){
        return cabinRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Cabin getCabinById(@PathVariable(value= "id") Integer id){
        return cabinRepository.getOne(id);
    }

    @GetMapping("/getAll/{floorNo}")
    public List<Cabin> getCabinsByFloorNo(@PathVariable("floorNo") Integer no){
        return cabinRepository.findByFloorNo(no);
    }

//    @PostMapping("/create/{empId}")
//    public Cabin createCabin(@PathVariable("empId") Integer id, @Valid @RequestBody Cabin cabin){
//        cabin.setEmployee(employeeRepository.getOne(id));
//        return cabinRepository.save(cabin);
//    }

    @PostMapping("/create")
    public Cabin createCabin( @Valid @RequestBody Cabin cabin){
        return cabinRepository.save(cabin);
    }


    @PutMapping("/delete/{id}")
    public void deleteCabin(@PathVariable("id") Integer id){
        cabinRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Cabin updateCabin(@PathVariable("id") Integer id, @Valid @RequestBody Cabin cabin){
        Cabin cabin1 =cabinRepository.getOne(id);
        cabin1.setEmployee(cabin.getEmployee());
        cabin1.setFloorNo(cabin.getFloorNo());
        cabin1.setRoomNo(cabin.getRoomNo());
        return cabinRepository.save(cabin1);
    }

}
