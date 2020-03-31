package com.example.sampleemployeespring.utils;

import java.util.LinkedList;
import java.util.List;

 class XYZ<T>{
    public void testFunc(String str, List<T> list){
        T a= list.get(0);
    }
}
class ABC{
    public static void main(String[] args) {
        ABC a1= new ABC();
        ABC a2 = new ABC();
//        Class<ABC> abc= new Class<ABC>();
        List<ABC> l= new LinkedList<>();
        l.add(a1);
        l.add(a2);
        XYZ a= new XYZ();
        XYZ<ABC> xyz= new XYZ<ABC>();
        xyz.testFunc("hello", l);
    }
}
