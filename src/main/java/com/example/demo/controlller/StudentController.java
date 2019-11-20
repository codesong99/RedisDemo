package com.example.demo.controlller;

import com.example.demo.Service.StudentService;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Song Weiwei
 * @date 2019-11-12
 */

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = {"/insert"})
    @ResponseBody
    public String insert(@RequestParam(value = "name") String name,
                         @RequestParam(value = "age") int age,
                         @RequestParam(value = "sex") String sex) {
        Student temp = studentService.findByName(name);
        if (temp != null) {
            return "该姓名已被注册";
        }

        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        student.setSex(sex);

        studentService.insert(student);

        return "学生插入成功";
    }

    @RequestMapping(path = {"/findByName"})
    @ResponseBody
    public Student findByName(@RequestParam(value = "name") String name) {
        long beginTime = System.currentTimeMillis();
        Student student = studentService.findByName(name);
        long endTime = System.currentTimeMillis();
        System.out.println("学生查询耗时： " + (endTime - beginTime));
        return student;
    }

}
