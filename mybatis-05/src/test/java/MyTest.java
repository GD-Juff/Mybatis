import com.Juff.dao.UserMapper;
import com.Juff.pojo.User;
import com.Juff.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(1);
        System.out.println(user);
        sqlSession.clearCache();//手动清理缓存
        System.out.println("=================================");
        User user2 = userMapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(1);
        System.out.println(user);

        userMapper.updateUser(new User(2,"aaa","bbb"));

        System.out.println("=================================");
        User user2 = userMapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = userMapper1.queryUserById(1);
        System.out.println(user1);
        User user2 = userMapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1==user2);
        System.out.println("=================================");
        User user3 = userMapper2.queryUserById(2);
        System.out.println(user3);
        User user4 = userMapper2.queryUserById(2);
        System.out.println(user4);
        System.out.println(user3==user4);
        System.out.println("=================================");

        sqlSession1.close();
        sqlSession2.close();

    }
}