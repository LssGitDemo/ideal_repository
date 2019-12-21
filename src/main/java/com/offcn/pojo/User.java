package com.offcn.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: wyan
 * @Date: 2019-12-19 09:22
 * @Description:
 */
@Data
@Entity
//@Table(name="tb_user")
public class User {

    @Id
    @GeneratedValue
    //@Column(name="user_id")
    private Integer id;
    @Column(name="name",length = 20,nullable = false)
    private String name;
    @Column(name="age",length = 4,nullable = true)
    private Integer age;
}
