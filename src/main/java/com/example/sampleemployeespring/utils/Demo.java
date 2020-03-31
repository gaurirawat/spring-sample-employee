package com.example.sampleemployeespring.utils;

import com.example.sampleemployeespring.controller.DepartmentController;
import com.example.sampleemployeespring.beans.Department;

public class Demo {
    public static void main(String[] args) {
        DepartmentController departmentController = new DepartmentController();
        Department d1= departmentController.getDeptById(1);
        d1.setName("biotechhhhh");
        departmentController.updateCabin(2, d1);
    }
}
