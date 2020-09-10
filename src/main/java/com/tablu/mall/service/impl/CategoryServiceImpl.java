package com.tablu.mall.service.impl;

import com.tablu.mall.dao.CategoryMapper;
import com.tablu.mall.pojo.Category;
import com.tablu.mall.pojo.QueryCategory;
import com.tablu.mall.service.CategoryService;
import com.tablu.mall.vo.CategoryVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.tablu.mall.consts.MallConst.ROOT_CATEGORY_PARENT_ID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> getCategories() {
        List<Category> categories = categoryMapper.selectAll();
        List<CategoryVo> res = createRootList(categories);
        fillRootList(res, categories);

        return ResponseVo.success(res);
    }

    @Override
    public QueryCategory getCategoryIdAndMarkSet(Integer categoryId) {
        Set<Integer> categoryIdSet = new HashSet<>();
        Set<Byte> categoryMarkSet = new HashSet<>();
        List<Category> categories = categoryMapper.selectAll();
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        categoryIdSet.add(categoryId);
        if (category.getMark() != null) {
            categoryMarkSet.add(category.getMark());
        }
        getCategoryIdAndMarkSet(categoryId, categories, categoryIdSet, categoryMarkSet);

        QueryCategory queryCategory = new QueryCategory();
        queryCategory.setCategoryIdSet(categoryIdSet);
        queryCategory.setMarkSet(categoryMarkSet);

        return queryCategory;
    }

    private void getCategoryIdAndMarkSet(Integer categoryId, List<Category> categories,
                                         Set<Integer> categoryIdSet, Set<Byte> categoryMarkSet) {
        for (Category category : categories) {
            if (category.getParentId().equals(categoryId)) {
                categoryIdSet.add(category.getId());
                if (category.getMark() != null) {
                    categoryMarkSet.add(category.getMark());
                }
                getCategoryIdAndMarkSet(category.getId(), categories, categoryIdSet, categoryMarkSet);
            }
        }
    }

    private void fillRootList(List<CategoryVo> rootList, List<Category> categories) {
        for (CategoryVo parentCategoryVo : rootList) {
            List<CategoryVo> subList = new ArrayList<>();

            for (Category category : categories) {
                if (category.getParentId().equals(parentCategoryVo.getId())) {
                    subList.add(categoryToVo(category));
                }
                subList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                parentCategoryVo.setSubCategories(subList);
                fillRootList(subList, categories);
            }
        }
    }

    private List<CategoryVo> createRootList(List<Category> categories) {
        List<CategoryVo> res = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParentId().equals(ROOT_CATEGORY_PARENT_ID)) {
                CategoryVo categoryVo = categoryToVo(category);
                res.add(categoryVo);
            }
        }
        res.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
        return res;
    }

    private CategoryVo categoryToVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }


}
