package org.example.mactrack.repository;

import org.example.mactrack.model.MealItem;
import org.example.mactrack.model.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealItemRepository extends JpaRepository<MealItem, Long> {
    List<MealItem> findAllByMealTypeAndDate(MealType mealType, LocalDate date);
}