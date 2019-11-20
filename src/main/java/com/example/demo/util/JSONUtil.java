package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.Teacher;
import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author Song Weiwei
 * @date 2019-11-12
 */
public class JSONUtil {

    public static String getJSONString(Teacher teacher) {
        return JSON.toJSONString(teacher);
    }

    public static Teacher getTeacherByJson(String str) {
        return JSON.parseObject(str,Teacher.class);
    }
}
