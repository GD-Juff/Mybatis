package com.Juff.dao;

import com.Juff.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//DAO (DataAccessobjects 数据存取对象)是指位于业务逻辑和持久化数据之间实现对持久化数据的访问。
//通俗来讲，就是将数据库操作都封装起来.对外提供相应的接口

public interface UserMapper {

    List<User> getUserLike(String value);
    //查询全部用户

    List<User> getUserList();

    //根据id查询用户

    User getUserById(int id);

    User getUserById2(Map<String, Object> map);

    //插入用户

    int addUser(User uer);

    //万能Map

    int addUser2(Map<String, Object> map);

    //修改用户

    int updateUser(User uer);

    //删除用户

    int deleteUser(int id);

    //分页

    List<User> getUserByLimit(Map<String, Integer> map);

    List<User> getUserByRowBounds();

    @Select("select * from user")
    List<User> getUsers();


    //方法存在多个参数，所有的参数必须加@Param

    @Select("select * from user where id = #{id}")
    User getUserById1(@Param("id") int id);

    @Insert("insert into user (id, name, pwd) values" +
            "(#{id},#{name},#{pwd})")
    int addUser1(User user);

    @Update("update user set name=#{name}, pwd=#{pwd} " +
            "where id=#{id}")
    int updateUser1(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser1(@Param("id") int id);
}