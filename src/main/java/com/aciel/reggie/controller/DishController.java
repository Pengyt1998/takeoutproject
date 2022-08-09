package com.aciel.reggie.controller;


import com.aciel.reggie.common.R;
import com.aciel.reggie.dto.DishDto;
import com.aciel.reggie.entity.Dish;
import com.aciel.reggie.service.CategoryService;
import com.aciel.reggie.service.DishFlavorService;
import com.aciel.reggie.service.DishService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜品管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishService dishService;
    @Resource
    private CategoryService categoryService;

    @Resource
    private DishFlavorService dishFlavorService;

    /**
     * 添加菜品
     * @param dishDto
     * @return
     */
    @PostMapping
    public R addDish(@RequestBody DishDto dishDto){
        dishService.addDish(dishDto);
        return R.success("新增菜品成功！");
    }

    /**
     * 分页查询菜单
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R page(int page ,int pageSize , String name){
        Page<DishDto> pageInfo = dishService.pageSearch(page,pageSize,name);
        return R.success(pageInfo);
    }


    /**
     * 根据id回显菜品信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getDishById(@PathVariable Long id){
        DishDto dishDto = dishService.getDishById(id);
        return R.success(dishDto);
    }

    /**
     * 修改菜品信息
     * @param dishDto
     * @return
     */
    @PutMapping
    public R update(@RequestBody DishDto dishDto){
        dishService.updateDish(dishDto);
        return R.success("修改菜品成功！");
    }

    /**
     * 根据id删除信息
     * @param ids
     * @return
     */
    @DeleteMapping
    public R delete(String  ids){
        dishService.deleteDish(ids);
        return R.success("删除成功");
    }

    /**
     * 更改菜品状态
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public R changeStatus(@PathVariable int status,String ids){
        String[] idList = ids.split(",");
        for (String id : idList) {
            Dish dish = new Dish();
            dish.setId(Long.parseLong(id));
            dish.setStatus(status);
            dishService.updateById(dish);
        }

        return R.success("更新状态成功");
    }

    /**
     * 根据类别返回该类菜单
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public R list(Long categoryId,Integer status){
        List<DishDto> dishDtoList = dishService.getList(categoryId,status);
        return R.success(dishDtoList);
    }
}

