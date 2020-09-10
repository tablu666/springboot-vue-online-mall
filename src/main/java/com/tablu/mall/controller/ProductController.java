package com.tablu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.service.ProductService;
import com.tablu.mall.vo.ProductDetailVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> product(@RequestParam(required = false) Integer categoryId,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.productList(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> productDetail(@PathVariable("productId") Integer productId) {
        return productService.productDetail(productId);
    }
}
