package org.example.mactrack.controllers;

import org.example.mactrack.model.MealItem;
import org.example.mactrack.model.MealType;
import org.example.mactrack.services.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meals")
@CrossOrigin
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public MealItem addMealItem(@RequestBody MealItem mealItem) {
        return mealService.addMealItem(mealItem);
    }
    @GetMapping("/total/{mealType}")
    public int getTotalCalories(@PathVariable MealType mealType) {
        return mealService.getTotalCaloriesForMeal(mealType);
}
}
