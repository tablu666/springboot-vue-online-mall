package com.tablu.mall.utils;

import com.tablu.mall.enums.RoleEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UrlRoleNameMapUtil {

    public static Map<String, ArrayList<String>> generateMenus() {
        Map<String, ArrayList<String>> urlRoleNameMap = new HashMap<>();
        RoleEnum[] roleEnums = RoleEnum.values();
        for (RoleEnum roleEnum : roleEnums) {
            updateRoleNameUrlMap("CUSTOMER", urlRoleNameMap, roleEnum);
            updateRoleNameUrlMap("EMPLOYEE", urlRoleNameMap, roleEnum);
            updateRoleNameUrlMap("MANAGER", urlRoleNameMap, roleEnum);
        }
        return urlRoleNameMap;
    }

    private static void updateRoleNameUrlMap(String role, Map<String, ArrayList<String>> urlRoleNameMap, RoleEnum roleEnum) {
        if (roleEnum.getRoleName().contains(role)) {
            ArrayList<String> roleNameList = urlRoleNameMap.getOrDefault(roleEnum.getUrl(), new ArrayList<>());
            roleNameList.add(roleEnum.getRoleName());
            urlRoleNameMap.put(roleEnum.getUrl(), roleNameList);
        }
    }

}
