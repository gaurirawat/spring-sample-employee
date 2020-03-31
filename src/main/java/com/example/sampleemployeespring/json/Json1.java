package com.example.sampleemployeespring.json;

import com.example.sampleemployeespring.beans.Cabin;
import com.example.sampleemployeespring.controller.CabinController;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("json1/")
public class Json1 {

    private CabinController cabinController= new CabinController();


    @GetMapping("/1")
    public String sendJSON(){
        JSONObject jo = new JSONObject();

        //insert general key-value pair
        jo.put("name", "Gauri");
        jo.put("age", "22");
        System.out.print(jo);
        //insert object
        Cabin cabin = cabinController.getCabinById(1);
        jo.put("cabin", cabin);
        jo.put("cabins", cabinController.getCabins());
        String s = jo.toString();

        return s;
    }


//    @GetMapping("/2")
//    public JSONObject sendJackson(){
//    }
}

