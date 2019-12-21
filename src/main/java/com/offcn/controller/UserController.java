package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019-12-19 09:49
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("user")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping("user/{id}")
    public User findById(@PathVariable Integer id){
        return userRepository.findById(id).get();
    }
    @PostMapping("user")
    public void saveUser(User user){
         userRepository.save(user);
    }
    @PutMapping("user")
    public void updadateUesr(User user){
        userRepository.saveAndFlush(user);
    }
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }
    @RequestMapping("findUserByName")
    public User findByName(String name){
        return userRepository.findByName(name);
    }

    //根据姓名模糊查询
    @RequestMapping("findByNameLike")
    public List<User> findByNameLike(String name){
        System.out.println(name);
        System.out.println("%"+name+"%");
        List<User> user =   userRepository.findByNameLike(name);
        System.out.println(user);
        return userRepository.findByNameLike("%"+name+"%");
    }
    //根据姓名和年龄 多条件查询
    @RequestMapping("findByNameAndAge")
    public List<User> findByNameAndAge(String name ,Integer age){
        return userRepository.findByNameAndAge(name,age);
    }
    //使用年龄大于查询
    @RequestMapping("findByAgeGreaterThan")
    public List<User> findByAgeGreaterThan(Integer age){
        return userRepository.findByAgeGreaterThan(age);
    }

    @RequestMapping("getUserById")
    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

    @RequestMapping("getByUserName")
    public User getByUserName(String name){
        //return userRepository.getByUserName(name);
        return userRepository.getByUserNameNative(name);
    }

    @RequestMapping("getByUserNameLike")
    public List<User> getByUserNameLike(String name){
        //return userRepository.getByUserNameLike(name);
        return userRepository.getByUserNameLikeNative(name);
    }

    @RequestMapping("getByNameAndAge")
    public List<User> getByNameAndAge(String name ,Integer age){
        //return userRepository.getByNameAndAge(name,age);
        return userRepository.getByNameAndAgeNative(name,age);
    }
}
