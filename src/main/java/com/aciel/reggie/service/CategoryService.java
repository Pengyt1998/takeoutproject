package com.aciel.reggie.service;

import com.aciel.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 */
public interface CategoryService extends IService<Category> {

    void delete(Long ids);
}
