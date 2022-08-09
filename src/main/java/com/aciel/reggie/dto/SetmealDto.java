package com.aciel.reggie.dto;


import com.aciel.reggie.entity.Setmeal;
import com.aciel.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
