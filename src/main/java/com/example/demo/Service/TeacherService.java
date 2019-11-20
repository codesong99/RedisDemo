package com.example.demo.Service;

import com.example.demo.pojo.Teacher;

import java.util.Map;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */
public interface TeacherService {

    Map<String,String> insert(Teacher teacher);

    Teacher findBySubject(String subject);
}
