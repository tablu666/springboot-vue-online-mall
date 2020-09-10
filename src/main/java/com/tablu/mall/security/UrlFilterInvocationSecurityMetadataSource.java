package com.tablu.mall.security;

import com.tablu.mall.utils.UrlRoleNameMapUtil;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //直接访问
        if("/user/login".equals(requestUrl)
                || "/user/register".equals(requestUrl)
                || (requestUrl).startsWith("/products")
                || "/categories".equals(requestUrl)) {
            return null;
        }
        //获取请求路径对应角色清单
        Map<String, ArrayList<String>> urlRoleNameMap = UrlRoleNameMapUtil.generateMenus();
        for (String url : urlRoleNameMap.keySet()) {
            if (antPathMatcher.match(url, requestUrl) && urlRoleNameMap.get(url).size() > 0) {
                ArrayList<String> roleNameList = urlRoleNameMap.get(url);
                String[] values = new String[roleNameList.size()];
                values = roleNameList.toArray(values);
                return SecurityConfig.createList(values);
            }
        }
        return SecurityConfig.createList("ROLE_USER");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
