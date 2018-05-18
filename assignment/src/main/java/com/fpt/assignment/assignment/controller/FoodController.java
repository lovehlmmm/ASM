package com.fpt.assignment.assignment.controller;


import com.fpt.assignment.assignment.entity.Food;
import com.fpt.assignment.assignment.entity.FoodValidator;
import com.fpt.assignment.assignment.model.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Optional;

@Controller
public class FoodController {

    @Autowired
    private FoodModel foodModel;

    @RequestMapping(path = "/food/create", method = RequestMethod.GET)
    public String createFood(@ModelAttribute Food p) {
        return "food-form";
    }

    @RequestMapping(path = "/food/create", method = RequestMethod.POST)
    public String saveFood(@Valid Food food, BindingResult result) {
        new FoodValidator().validate(food, result);
        if (result.hasErrors()) {
            return "food-form";
        }
        foodModel.save(food);
        return "redirect:/food/list";
}

    @RequestMapping(path = "/food/edit/{id}", method = RequestMethod.GET)
    public String editFood(@PathVariable int id, Model model) {
        Optional<Food> optionalFood = foodModel.findById(id);
        if (optionalFood.isPresent()) {
            model.addAttribute("food", optionalFood.get());
            return "food-form";
        } else {
            return "not-found";
        }
    }

//    @RequestMapping(path = "/product/edit/{id}", method = RequestMethod.POST)
//    public String updateProduct(@PathVariable int id,@Valid Product product, BindingResult result, Model model){
//        Optional<Product> optionalProduct = productModel.findById(id);
//        if (optionalProduct.isPresent()) {
//            if (result.hasErrors()) {
//                return "product-form";
//            }
//            productModel.save(product);
//            return "redirect:/product/list";
//        } else {
//            return "not-found";
//        }
//    }

    @RequestMapping(path = "/food/delete/{id}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable int id) {
        Optional<Food> optionalFood = foodModel.findById(id);
        if (optionalFood.isPresent()) {
            foodModel.delete(optionalFood.get());
            return "redirect:/food/list";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/food/list", method = RequestMethod.GET)
    public String getListFood(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        model.addAttribute("pagination", foodModel.findAll(PageRequest.of(page - 1, limit)));
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("datetime", Calendar.getInstance().getTime());
        return "food-list";
    }
}

