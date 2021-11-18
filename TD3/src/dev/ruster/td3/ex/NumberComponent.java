package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record NumberComponent(Scanner scan) {

    public NumberComponent(@NotNull final Scanner scan) {
        this.scan = scan;
        
        System.out.println(squareNumberCount(scan.nextInt()));
    }

    public int numberCount(int n) {
        boolean canBeDivided = true;
        int count = 0;

        while(canBeDivided) {
            if(n < 10) {
                canBeDivided = false;
            }
            n /= 10;
            count++;
        }
        return count;
        //return String.valueOf(n).length();
    }

    public int squareNumberCount(int n) {
        return numberCount(n * n);
    }

    public static int getNumberUnit(int n) {
        boolean canBeDivided = true;

        while(canBeDivided) {
            if(n < 10) {
                canBeDivided = false;
                continue;
            }
            n %= 10;
        }
        return n;
    }
}