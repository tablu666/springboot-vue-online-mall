package com.tablu.mall.service.impl;

import com.tablu.mall.dao.UserMapper;
import com.tablu.mall.dao.UserRoleMapper;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.pojo.User;
import com.tablu.mall.pojo.UserRoleKey;
import com.tablu.mall.service.UserService;
import com.tablu.mall.vo.ResponseVo;
import com.tablu.mall.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.tablu.mall.consts.MallConst.CUSTOMER_ID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @Override
    public ResponseVo userRegister(User user) {
        return getResponseVo(user, CUSTOMER_ID);
    }

    @Override
    public ResponseVo<UserVo> userProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setPassword(null);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return ResponseVo.success(userVo);
    }

    @Override
    public ResponseVo<User> userProfileByManagement(String username) {
        User user = userMapper.selectByUsername(username);
        user.setPassword(null);
        return ResponseVo.success(user);
    }

    @Override
    public ResponseVo<List<User>> userListByManagement() {
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {
            user.setPassword(null);
        }
        return ResponseVo.success(userList);
    }

    private ResponseVo getResponseVo(User user, Integer roleId) {
        ResponseVo responseVo = infoPreHandler(user);
        if (responseVo != null) {
            return responseVo;
        }
        //mall_user_role关系维护
        int uid = userMapper.getIdByUsername(user.getUsername());
        int res = userRoleMapper.insert(new UserRoleKey(uid, roleId));
        return res == 0 ? ResponseVo.error() : ResponseVo.successByMsg("注册成功");
    }

    private ResponseVo infoPreHandler(User user) {
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        //存入用户
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int res = userMapper.insertSelective(user);
        if (res == 0) {
            return ResponseVo.error();
        }

        return null;
    }
}
