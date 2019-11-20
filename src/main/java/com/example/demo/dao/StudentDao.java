package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */

@Repository
public interface StudentDao {

    int insert(Student student);

    Student findByName(String name);
}
