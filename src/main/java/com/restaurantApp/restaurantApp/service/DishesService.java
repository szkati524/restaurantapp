package com.restaurantApp.restaurantApp.service;

import com.restaurantApp.restaurantApp.resources.Dishes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class DishesService {

    Dishes dishes = new Dishes();
    List<Dishes> dishesList = new ArrayList<>();

}
