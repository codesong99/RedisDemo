package com.example.demo.util;

import com.example.demo.pojo.Teacher;
//import jdk.internal.vm.compiler.collections.EconomicMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Song Weiwei
 * @date 2019-11-12
 */
@Service
public class JedisAdapter implements InitializingBean {

    private JedisPool pool;

    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool("redis://localhost:6379/10");
    }

    public boolean hasKey(String subject) {
        try(Jedis jedis = pool.getResource()) {
            return jedis.exists("jedis_teacher_" + subject);
        }
    }

    public void insert(Teacher teacher) {
        String str = JSONUtil.getJSONString(teacher);//首先序列化转为字符串
        try(Jedis jedis = pool.getResource()) {
            jedis.set("jedis_teacher_" + teacher.getSubject(), str);//key是jedis_teacher_math, value就是教师对象的json串
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Teacher get(String subject) {
        try(Jedis jedis = pool.getResource()) {
            String str = jedis.get("jedis_teacher_" + subject);
            return JSONUtil.getTeacherByJson(str);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
