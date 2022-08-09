package com.aciel.reggie.dto;

import com.aciel.reggie.entity.Dish;
import com.aciel.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aciel
 * @version 1.0
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}

