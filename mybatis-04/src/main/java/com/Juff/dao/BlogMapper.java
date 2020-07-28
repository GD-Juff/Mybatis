package com.Juff.dao;

import com.Juff.pojo.Blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(HashMap map);

    int updateBlog(Map map);

    List<Blog> queryBlogIF2(HashMap map);

    List<Blog> queryBlogForeach(Map map);
}
