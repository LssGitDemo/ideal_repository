package com.offcn.repository;

import com.offcn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019-12-19 09:45
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /*
    * 一套的增删改查最基本的已经被实现了
    * */
    //根据姓名查询 完全匹配
    public User findByName(String name);
    //根据姓名模糊查询
    public List<User> findByNameLike(String name);
    //根据姓名和年龄 多条件查询
    public List<User> findByNameAndAge(String name ,Integer age);
    //使用年龄大于查询
    public List<User> findByAgeGreaterThan(Integer age);
    /*
    * ----------------------------jqpl的查询测试--------------------------------------
    * */
    @Query("select u  from User u where u.id = ?1 ")
    public User getUserById(Integer userId);

    @Query("select u  from User u  ")
    public User getUsers();

    @Query("select u from User u where u.name= ?1")
    public User getByUserName(String name);

    @Query("select u from User u where u.name like %:name% ")
    public List<User> getByUserNameLike( @Param("name") String name);

    @Query("select u from User u where u.name = ?1 and age = ?2")
    public List<User> getByNameAndAge(@Param("name")String name , @Param("age")Integer age);

    //---------------------------原始sql执行数据库的查询---------------------------
    @Query(value = "select * from user where name = ? ",nativeQuery = true)
    public User getByUserNameNative(String name);

    @Query(value = "select * from user u where u.name like %?% ",nativeQuery = true)
    public List<User> getByUserNameLikeNative( String name);

    @Query(value = "select * from user u where u.name = ? and age = ?",nativeQuery = true)
    public List<User> getByNameAndAgeNative(@Param("name")String name , @Param("age")Integer age);

}
