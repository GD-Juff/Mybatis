import com.Juff.dao.TeacherMapper;
import com.Juff.pojo.Teacher;
import com.Juff.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {

//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        for (Teacher teacher : sqlSession.getMapper(TeacherMapper.class).getTeacher()) {
//            System.out.println(teacher);
//        }
//        sqlSession.close();
//    }

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}
