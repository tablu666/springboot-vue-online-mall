package com.tablu.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tablu.mall.dao.ProductMapper;
import com.tablu.mall.enums.ProductStatusEnum;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.QueryCategory;
import com.tablu.mall.service.CategoryService;
import com.tablu.mall.service.ProductService;
import com.tablu.mall.vo.ProductDetailVo;
import com.tablu.mall.vo.ProductVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseVo<PageInfo> productList(Integer categoryId, Integer pageNum, Integer pageSize) {
        QueryCategory queryCategory = null;
        if (categoryId != null) {
            queryCategory = categoryService.getCategoryIdAndMarkSet(categoryId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByQueryCategory(queryCategory);
        List<ProductVo> productVoList = productList.stream().map(product -> {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(product, productVo);
            return productVo;
        }).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);

        return ResponseVo.success(pageInfo);

    }

    @Override
    public ResponseVo<ProductDetailVo> productDetail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (ProductStatusEnum.OFF_SALE.getCode().equals(product.getStatus())
                || ProductStatusEnum.DELETE.getCode().equals(product.getStatus())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STATUS_ERROR);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        Integer stock = product.getStock() > 100 ? 100 : product.getStock();
        productDetailVo.setStock(stock);
        return ResponseVo.success(productDetailVo);
    }

}
