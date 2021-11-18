package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record ArrayProcess(Scanner scan) {

    public ArrayProcess(@NotNull final Scanner scan) {
        this.scan = scan;

        processIntArray();
        System.out.println();
    }

    public void displayIntArray(int[] array) {
        System.out.println("Tableau : " + Arrays.toString(array));
    }

    public int @NotNull [] scanIntArray(int size) {
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            System.out.print("Entier numéro " + (i + 1 + " : "));
            array[i] = scan.nextInt();
        }
        return array;
    }

    public double getAverage(int @NotNull [] array) {
        int sum = 0;

        for(int i : array) {
            sum += i;
        }
        return sum / (double) array.length;
        //return Arrays.stream(array).average().orElse(-1);
    }

    public void processIntArray() {
        int[] array = scanIntArray(10);

        displayIntArray(array);
        System.out.println("Moyenne : " + getAverage(array));

        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                array[i] += 1;
            }
        }
        System.out.print("Tableau modifié : " + Arrays.toString(array));
    }
}