package com.Juff.dao;

import com.Juff.pojo.User;
import com.Juff.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(String.valueOf(UserMapperTest.class));

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
//        方式一:推荐
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();

//        方式二:以前的做法
//        List<User> userList=sqlSession.selectList("com.Juff.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.getUserLike("%俊%");
        List<User> userList = mapper.getUserLike("俊");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("helloId", 1);
        System.out.println(mapper.getUserById2(map));
        sqlSession.close();
    }


    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "God", "10096"));
        if (res > 0) {
            System.out.println("insert success!");
        }
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 5);
        map.put("userName", "Hello");
        map.put("password", "2222333");
        mapper.addUser2(map);
        //增删改需要提交事务
        sqlSession.commit();
        System.out.println("insert success");
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4, "God", "233233"));
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testLog4j() {
        logger.info("info:进入了testlog4j");
        logger.debug("debug:进入了testlog4j");
        logger.error("error:进入了testlog4j");
    }

    @Test
    public void getByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过java代码层面
        List<User> userList = sqlSession.selectList
                ("com.Juff.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUsers(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUsers();
            for (User user : userList) {
                System.out.println(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    @Test
    public void getuserById(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            User user = userDao.getUserById(1);

            System.out.println(user);


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    @Test
    public void addUser1(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            userDao.addUser1(new User(6, "kun","123"));
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    @Test
    public void updateUser1(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            userDao.updateUser1(new User(6, "fang","123"));
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser1(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            userDao.deleteUser1(6);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }
}
