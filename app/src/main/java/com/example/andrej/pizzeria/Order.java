package com.example.andrej.pizzeria;

import java.util.ArrayList;

/**
 * Created by Andrej on 26.5.2016..
 */
public class Order {
    private static Order instance;
    private static ArrayList<FoodItemModel> list = new ArrayList<>();

    public static synchronized Order getInstance(){
        if(instance==null){
            instance = new Order();
        }
        return instance;
    }

    public void addToCard(FoodItemModel food){
        list.add(food);
    }

    public ArrayList<FoodItemModel> getAllProducts(){
        return list;
    }

    public void clearOrder(){
        list.clear();
    }
}
