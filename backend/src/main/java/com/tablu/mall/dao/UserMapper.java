package com.tablu.mall.dao;

import com.tablu.mall.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    int countByUsername(String username);

    int countByEmail(String email);

    int getIdByUsername(String username);

    List<User> selectAll();

}