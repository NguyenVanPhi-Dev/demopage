package com.example.demopage.dto;

import com.example.demopage.model.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class DishDTO {
    private List<Dish> dish;
    private Integer currentPage;
    private Integer totalPage;

    public DishDTO(List<Dish> dish) {
        this.dish = dish;
    }

}
