package dev.ruster.tp2.utils;

import java.util.Random;

public class Util {

    private static final Random r = new Random();

    public static int randomIntBetween(int min, int max) {
        return r.nextInt(max - min) + min;
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}