package com.example.demo.dao;

import com.example.demo.pojo.Teacher;
import org.springframework.stereotype.Repository;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */

@Repository
public interface TeacherDao {

    int insert(Teacher teacher);

    Teacher findBySubject(String string);
}
