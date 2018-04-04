package com.example.admin.zoodatabase;

import java.util.Random;

public class RandomRange {
    static Random rand = new Random();
    public static int randInt(int min, int max)
    {
        return rand.nextInt((max - min) + 1) + min;
    }
    public static double randDouble(double min, double max)
    {
        return min + (max - min) * rand.nextDouble();
    }
}
