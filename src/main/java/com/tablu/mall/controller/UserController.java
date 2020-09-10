package com.tablu.mall.controller;

import com.tablu.mall.form.UserRegisterForm;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.UserService;
import com.tablu.mall.utils.VerificationCodeUtil;
import com.tablu.mall.vo.ResponseVo;
import com.tablu.mall.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse response) throws IOException {
        VerificationCodeUtil codeUtil = new VerificationCodeUtil();
        BufferedImage image = codeUtil.getImage();
        String text = codeUtil.getText();
        session.setAttribute("verify_code", text);
        VerificationCodeUtil.outputImage(image, response.getOutputStream());
    }

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.userRegister(user);
    }

    @GetMapping("/user/profile")
    public ResponseVo<UserVo> profile() {
        return userService.userProfile();
    }

}
