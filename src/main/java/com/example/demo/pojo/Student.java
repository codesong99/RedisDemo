package com.example.demo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */
@Getter
@Setter
@NoArgsConstructor
public class Student implements Serializable {
    private int id;
    private String name;    //保证唯一性
    private int age;
    private String sex;

}
