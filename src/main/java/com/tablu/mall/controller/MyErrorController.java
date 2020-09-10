package com.tablu.mall.controller;

import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public ResponseVo handler() {
        return ResponseVo.error(ResponseEnum.PAGE_NOT_FOUND);
    }
}
