package com.tablu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.OrderStatusForm;
import com.tablu.mall.form.ProductAddForm;
import com.tablu.mall.form.ProductUpdateForm;
import com.tablu.mall.form.RoleForm;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.Role;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.BackendService;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OmsController {

    @Autowired
    private BackendService backendService;

//    @GetMapping("/seller")
//    public ResponseVo<PageInfo> ordersWithStatus(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
//                                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum,
//                                                 @RequestParam(required = false) Integer status) {
//        return backendService.filteredOrders(pageSize, pageNum, status);
//    }

    @PostMapping("/seller")
    public ResponseVo<PageInfo> orders(@Valid @RequestBody OrderStatusForm orderStatusForm) {
        Integer pageSize = orderStatusForm.getPageSize();
        Integer pageNum = orderStatusForm.getPageNum();
        Integer status = orderStatusForm.getStatus();
        return backendService.filteredOrders(pageSize, pageNum, status);
    }

    @GetMapping("/seller/{userId}")
    public ResponseVo<PageInfo> customerOrder(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                              @PathVariable Integer userId) {
        return backendService.customerOrder(pageSize, pageNum, userId);
    }

    @GetMapping("/management/roles")
    public ResponseVo<List<Role>> roleList() {
        return backendService.roleList();
    }

    @PostMapping("/management/roles")
    public ResponseVo<Role> addRole(@Valid @RequestBody RoleForm roleForm) {
        return backendService.addRole(roleForm);
    }

    @PutMapping("/management/roles")
    public ResponseVo<Role> updateRole(@Valid @RequestBody RoleForm roleForm) {
        return backendService.updateRole(roleForm);
    }

    @GetMapping("/management/products")
    public ResponseVo<List<Product>> productList() {
        return backendService.productList();
    }

    @PostMapping("/management/products")
    public ResponseVo<Product> addProduct(@Valid @RequestBody ProductAddForm productAddForm) {
        return backendService.addProduct(productAddForm);
    }

    @PutMapping("/management/products")
    public ResponseVo<Product> updateProduct(@Valid @RequestBody ProductUpdateForm productUpdateForm) {
        return backendService.updateProduct(productUpdateForm);
    }

    @GetMapping("/management/users/{username}")
    public ResponseVo<User> getUser(@PathVariable String username) {
        return backendService.getUser(username);
    }

    @GetMapping("/management/users")
    public ResponseVo<List<User>> getAllUsers() {
        return backendService.userList();
    }

}
