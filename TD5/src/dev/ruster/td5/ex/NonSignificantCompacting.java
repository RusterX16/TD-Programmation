package dev.ruster.td5.ex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record NonSignificantCompacting(Scanner scan) {

    public NonSignificantCompacting(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(Arrays.toString(compacting(new int[]{3, 0, 4, 4, 0, 2, 0, -2})));
        System.out.println();
    }

    @Contract(pure = true)
    public int @NotNull [] compacting(int @NotNull [] array) {
        int[] output = new int[array.length];

        for(int x = 0, i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                output[x] = array[i];
                x++;
            }
        }
        return output;
    }
}