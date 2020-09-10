package com.tablu.mall.service;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.ProductAddForm;
import com.tablu.mall.form.ProductUpdateForm;
import com.tablu.mall.form.RoleForm;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.Role;
import com.tablu.mall.pojo.User;
import com.tablu.mall.vo.ResponseVo;

import java.util.List;

public interface BackendService {

    ResponseVo<PageInfo> filteredOrders(Integer pageSize, Integer pageNum, Integer status);

    ResponseVo<PageInfo> customerOrder(Integer pageSize, Integer pageNum, Integer userId);

    ResponseVo<List<Role>> roleList();

    ResponseVo<Role> addRole(RoleForm roleForm);

    ResponseVo<Role> updateRole(RoleForm roleForm);

    ResponseVo<List<Product>> productList();

    ResponseVo<Product> addProduct(ProductAddForm productAddForm);

    ResponseVo<Product> updateProduct(ProductUpdateForm productUpdateForm);

    ResponseVo<User> getUser(String username);

    ResponseVo<List<User>> userList();

}
