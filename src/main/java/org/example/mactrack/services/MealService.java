package org.example.mactrack.services;

import org.example.mactrack.model.MealItem;
import org.example.mactrack.model.MealType;
import org.example.mactrack.repository.MealItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    private final MealItemRepository mealItemRepository;

    public MealService(MealItemRepository mealItemRepository) {
        this.mealItemRepository = mealItemRepository;
    }

    public MealItem addMealItem(MealItem mealItem) {
        mealItem.setDate(LocalDate.now());
        return mealItemRepository.save(mealItem);
    }

    public int getTotalCaloriesForMeal(MealType mealType) {
        LocalDate today = LocalDate.now();
        List<MealItem> items = mealItemRepository.findAllByMealTypeAndDate(mealType, today);
        return items.stream().mapToInt(MealItem::getCalories).sum();
    }
}
