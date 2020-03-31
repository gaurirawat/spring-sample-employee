package com.example.sampleemployeespring.controller;

import com.example.sampleemployeespring.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService<T> {

    @Autowired
    EmployeeRepository employeeRepository;


    private ObjectMapper mapper = new ObjectMapper();
    public JsonService(){
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public List<T> fromJsonList(String jsonString, String key, Class<T> tClass) throws JsonProcessingException {
        JsonNode node = mapper.readTree(jsonString);
        String str = node.get(key).toString();

        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
//        List<Employee> employees= mapper.readValue(str, listType);
//        System.out.println(employees.getClass());
//        System.out.println( employees.get(0));
//        System.out.println(employees.get(0).getName());

        List<T> t= mapper.readValue(str, listType);
//        System.out.println(t.getClass());
//        System.out.println( t.get(0));
//        List<T> objects= mapper.readValue(str, new TypeReference<List<T>>() {});
        return t;

    }



}
