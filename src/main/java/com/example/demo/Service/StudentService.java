package com.example.demo.Service;

import com.example.demo.pojo.Student;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */
public interface StudentService {

    Student insert(Student student);

    Student findByName(String name);
}
