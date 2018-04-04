package com.example.admin.zoodatabase;

import java.util.ArrayList;
import java.util.List;

public class AppModel {
    private static List<Animal> animals = new ArrayList<>();

    public static List<Animal> getAnimals() {
        return animals;
    }
}
