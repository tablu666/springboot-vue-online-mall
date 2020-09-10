package com.tablu.mall.service;

import com.tablu.mall.pojo.User;
import com.tablu.mall.vo.ResponseVo;
import com.tablu.mall.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    ResponseVo userRegister(User user);

    ResponseVo<UserVo> userProfile();

    ResponseVo<User> userProfileByManagement(String username);

    ResponseVo<List<User>> userListByManagement();
}
