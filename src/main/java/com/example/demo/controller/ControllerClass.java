package com.example.demo.controller;

import com.example.demo.RequestClass;
import com.example.demo.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerClass {

    @PostMapping("/test")
    public void test(@RequestBody RequestClass requestClass){

        System.out.println("coming in here bro");
        Map<String, List<Student>> studentMap = new HashMap<>();

        for (int i =0; i< requestClass.getStudents().size(); i++){
            String name = requestClass.getStudents().get(i).getName();
            if (studentMap.containsKey(name)){
                studentMap.get(name).add(requestClass.getStudents().get(i));
            }else{
                List<Student> studentList = new ArrayList<>();
                studentList.add(requestClass.getStudents().get(i));
                studentMap.put(name,studentList);
            }
        }

        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            String key = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println("Key: " + key + ", Value:  " + students);
        }
    }
}
