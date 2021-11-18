package dev.ruster.td5.ex;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public record MoreFrequentNumber(Scanner scan) {

    public MoreFrequentNumber(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(moreFrequent(new int[]{1, 2, 2, 6, -4, 1, 2}));
        System.out.println();
    }

    public int moreFrequent(int @NotNull[] array) {
        Map<Integer, Integer> occurence = new HashMap<>();
        int integer = 0;
        int max = 0;

        for(int i : array) {
            if(occurence.containsKey(i)) {
                occurence.put(i, occurence.get(i) + 1);
            } else {
                occurence.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : occurence.entrySet()) {
            if(entry.getValue() > max) {
                integer = entry.getKey();
                max = entry.getValue();
            }
        }
        return integer;
    }
}