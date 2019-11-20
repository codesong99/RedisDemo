package com.example.demo.Service.Impl;

import com.example.demo.Service.StudentService;
import com.example.demo.dao.StudentDao;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao = null;

    private Random random = new Random(1);

    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_student_'+#result.name")
    public Student insert(Student student) {
        try{
            Thread.sleep(random.nextInt(10)*100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        studentDao.insert(student);
        return student;
    }

    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_student_'+#name")
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

}
