package com.aciel.reggie.service;

import com.aciel.reggie.dto.SetmealDto;
import com.aciel.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 套餐 服务类
 * </p>
 */
public interface SetmealService extends IService<Setmeal> {

    void add(SetmealDto setmealDto);

    Page<SetmealDto> getPage(Integer page, Integer pageSize, String name);

    SetmealDto getSetmeal(Long ids);

    void updateSetmeal(SetmealDto setmealDto);

    void delete(String  ids);
}
