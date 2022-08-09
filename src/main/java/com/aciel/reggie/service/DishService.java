package com.aciel.reggie.service;

import com.aciel.reggie.dto.DishDto;
import com.aciel.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 */
public interface DishService extends IService<Dish> {

    // 添加菜品
    void addDish(DishDto dishDto);

    Page<DishDto> pageSearch(int page, int pageSize, String name);

    DishDto getDishById(Long id);

    void updateDish(DishDto dishDto);

    void deleteDish(String  ids);

    List<DishDto> getList(Long categoryId, Integer status);
}
