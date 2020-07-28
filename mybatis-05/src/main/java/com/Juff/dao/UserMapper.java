package com.Juff.dao;

import com.Juff.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("id") int id);

    int updateUser(User user);
}
