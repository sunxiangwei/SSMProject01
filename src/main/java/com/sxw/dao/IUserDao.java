package com.sxw.dao;

import com.sxw.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from t_user where uname=#{uname} and upass=#{upass}")
    public boolean login(@Param("uname") String uname, @Param("upass") String upass);

    public User findById(Integer id);

    public void insertUsers(List<User> userList);

    public List<User> findAll();
}
