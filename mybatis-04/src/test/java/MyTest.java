import com.Juff.dao.BlogMapper;
import com.Juff.pojo.Blog;
import com.Juff.utils.IDutils;
import com.Juff.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setAuthor("Juff");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        blog.setTitle("Mybatis如此简单");

        blogMapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("java如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("spring如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "java如此简单");
        map.put("author", "Juff");
        List<Blog> list = blogMapper.queryBlogIF(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "java如此简单");
        map.put("author", "kuang");
        map.put("views", 9);
        List<Blog> list = blogMapper.queryBlogChoose(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "java如此简单啊");
        map.put("author", "Juff说");
        map.put("id", "9234f29dbc8b4ccca5a9b8230c9320e7");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "spring如此简单");
//        map.put("author", "Juff");
//        map.put("id","73b0eeead2b747ad934a792462ad6516");
//        map.put("views",9999);
        List<Blog> list = blogMapper.queryBlogIF2(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        ArrayList<String> ids = new ArrayList<String>();
        ids.add("df50a474c4314974b6b3254ba525459f");
        ids.add("73b0eeead2b747ad934a792462ad6516");

        map.put("ids", ids);
        List<Blog> list = blogMapper.queryBlogForeach(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}