package dev.ruster.td5.ex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public record LongestTraySearch(Scanner scan) {

    public LongestTraySearch(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(search(new char[]
                {'1', 'A', 'A', '!', '4', 'A', '1'}
        ));
        System.out.println();
    }

    @Contract(pure = true)
    public Character search(char @NotNull [] array) {
        Map<Character, Integer> occurence = new HashMap<>();
        char character = 0;
        int max = 0;

        for(char c : array) {
            if(occurence.containsKey(c)) {
                occurence.put(c, occurence.get(c) + 1);
            } else {
                occurence.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : occurence.entrySet()) {
            if(entry.getValue() > max) {
                character = entry.getKey();
                max = entry.getValue();
            }
        }
        return character;
    }
}