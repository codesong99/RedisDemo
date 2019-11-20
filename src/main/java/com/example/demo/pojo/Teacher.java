package com.example.demo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Song Weiwei
 * @date 2019-11-11
 */
@NoArgsConstructor
@Getter
@Setter
public class Teacher implements Serializable {

    private final long serialVersionUID = 1l;
    private int id;
    private String subject;
    private String name;
}
