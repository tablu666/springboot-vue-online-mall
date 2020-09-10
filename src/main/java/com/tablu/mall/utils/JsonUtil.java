package com.tablu.mall.utils;

import com.google.gson.Gson;
import com.tablu.mall.vo.ResponseVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {

    private static Gson gson;

    static {
        gson = new Gson();
    }

    public static void jsonOutput(ResponseVo responseVo, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(gson.toJson(responseVo));
        out.flush();
        out.close();
    }
}
