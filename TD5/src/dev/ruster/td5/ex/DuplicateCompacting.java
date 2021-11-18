package dev.ruster.td5.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record DuplicateCompacting(Scanner scan) {

    public DuplicateCompacting(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(Arrays.toString(compacting(new int[]{4, 0, 5, 2, 0, 0, 2, 4, 0, 4})));
        System.out.println();
    }

    public int @NotNull[] compacting(int @NotNull[] array) {
        int[] output = new int[array.length];

        for(int x = 0, i = 0; i < array.length; i++) {
            int temp = i;

            if(array[i] != 0 && Arrays.stream(output).noneMatch(v -> v == array[temp])) {
                output[x] = array[i];
                x++;
            }
        }
        return output;
    }
}