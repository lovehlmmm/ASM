package com.fpt.assignment.assignment.model;

 import com.fpt.assignment.assignment.entity.Food;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodModel
        extends PagingAndSortingRepository<Food, Integer> {

}
