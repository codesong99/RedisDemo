package com.example.demo.controlller;

import com.example.demo.Service.TeacherService;
import com.example.demo.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Song Weiwei
 * @date 2019-11-12
 */

@Controller
@RequestMapping(path = {"/teacher"})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(path = {"/insert"})
    @ResponseBody
    public String insert(@RequestParam(value = "name") String name,
                         @RequestParam(value = "subject") String subject) {

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSubject(subject);
        Map<String,String> map = teacherService.insert(teacher);
        if (map.containsKey("msg")) {
            return map.get("msg");
        }

        return "教师插入成功";
    }

    @RequestMapping(path = {"/findBySubject"})
    @ResponseBody
    public Teacher findBySubject(@RequestParam(value = "subject") String subject) {
        return teacherService.findBySubject(subject);
    }

}
