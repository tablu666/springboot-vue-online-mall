package com.tablu.mall.service;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.vo.ProductDetailVo;
import com.tablu.mall.vo.ResponseVo;

public interface ProductService {

    ResponseVo<PageInfo> productList(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> productDetail(Integer productId);
}
