package com.example.demopage.controller;

import com.example.demopage.dto.DishDTO;
import com.example.demopage.model.Dish;
import com.example.demopage.model.Tables;
import com.example.demopage.repository.DishRepository;
import com.example.demopage.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private TableRepository tableRepository;
    @GetMapping("page")
    public List<Dish> getdish(){
        return dishRepository.findAll();
    }

    @GetMapping("/phantrang/{id}")
    public DishDTO getPage(@PathVariable("id") Long id) {
        Sort sort = Sort.by("name").ascending();
        int pageSize = 2; // Kích thước trang (số món ăn trên mỗi trang)
        int pageNumber = id.intValue(); // Số trang được yêu cầu

        PageRequest pageable = PageRequest.of(pageNumber, pageSize,sort);
        Page<Dish> dishPage = dishRepository.findAll(pageable);
        DishDTO dishList = new DishDTO(dishPage.getContent());
        dishList.setCurrentPage(dishPage.getNumber());
        dishList.setTotalPage(dishPage.getTotalPages());

        return dishList;
    }
    @PostMapping("addTable")
    public Tables addTable(@Valid @RequestBody Tables tables){
        return tableRepository.save(tables);
    }
    @PostMapping("addDish")
    public Dish addDish(@Valid @RequestBody Dish dish) { return dishRepository.save(dish);}
}

