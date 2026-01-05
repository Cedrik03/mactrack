package org.example.mactrack.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int calories;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private LocalDate date;

    public MealItem() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public MealType getMealType() {
        return mealType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}