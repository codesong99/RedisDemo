package com.example.demo.Service.Impl;

import com.example.demo.Service.TeacherService;
import com.example.demo.dao.TeacherDao;
import com.example.demo.pojo.Teacher;
import com.example.demo.util.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Song Weiwei
 * @date 2019-11-12
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private JedisAdapter jedisAdapter;

    @Override
    public Map<String,String> insert(Teacher teacher) {

        Map<String, String> map = new HashMap<>();
        Teacher temp = teacherDao.findBySubject(teacher.getSubject());
        if(temp != null) {
            map.put("msg","该科目已被注册");
        }
        if(teacherDao.insert(teacher) == 0) {
            map.put("msg", "插入失败");
        }
        return map;
    }

    @Override
    public Teacher findBySubject(String subject) {

        if(jedisAdapter.hasKey(subject)) {
            System.out.println("通过Redis读取 ");
            long beginTime = System.currentTimeMillis();
            Teacher teacher = jedisAdapter.get(subject);
            long endTime = System.currentTimeMillis();
            System.out.println("Redis耗时：" + (endTime - beginTime));
            return teacher;
        } else {
            System.out.println("通过MySQL读取 ");
            long beginTime = System.currentTimeMillis();
            Teacher teacher = teacherDao.findBySubject(subject);
            long endTime = System.currentTimeMillis();
            System.out.println("MySQL耗时： " + (endTime - beginTime));

            //此时再插入到Redis中
            jedisAdapter.insert(teacher);

            return teacher;

        }

    }

}
