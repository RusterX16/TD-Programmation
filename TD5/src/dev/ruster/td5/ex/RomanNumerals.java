package dev.ruster.td5.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record RomanNumerals(Scanner scan) {

    public RomanNumerals(Scanner scan) {
        this.scan = scan;

        for(int i = 1; i < 10; i++) {
            numeralDivine(i);
        }
        System.out.println();
    }

    public String @NotNull [] getRomanNumerals() {
        String[] numerals = new String[9];
        String[] values = {"V", "", "X"};
        int[] key = {4, 5, 9};
        int[] sub = {1, 0, 2};
        String result = "";
        int t = 0;

        for(int i = 0; i < numerals.length; i++) {
            if(i == key[0] - 1 || i == key[1] - 1 || i == key[2] - 1) {
                result = result
                        .substring(1, result.length() - sub[t])
                        .concat(values[t]);
                t++;
                numerals[i] = result;
                continue;
            }
            result = result.concat("I");
            numerals[i] = result;
        }
        return numerals;
    }

    private void numeralUnit(int nb) {
        if(nb < 0 || nb > 9) {
            throw new IllegalArgumentException("nb doit être entre 0 et 9");
        }
        String[] values = {"V", "", "X"};
        int[] key = {4, 5, 9};
        int[] sub = {1, 0, 2};
        String result = "";
        int t = 0;

        for(int i = 0; i < nb; i++) {
            if(i == key[0] - 1 || i == key[1] - 1 || i == key[2] - 1) {
                result = result
                        .substring(1, result.length() - sub[t])
                        .concat(values[t]);
                t++;
                continue;
            }
            result = result.concat("I");
        }
        System.out.println(result);
    }

    public void numeralDivine(int nb) {
        System.out.println(getRomanNumerals()[nb].replace("I", "X"));
    }

    /*public void numeralUnit(int nb) {
        if(nb < 0 || nb > 9) {
            throw new IllegalArgumentException("nb doit être entre 0 et 9");
        }
        int[] array = {4, 5, 8};
        Map<Integer, String> map = Map.of(array[1], "", array[0], "V", array[2], "X");
        String result = "";
        int count = 0;

        for(int i = 0; i < nb; i++) {
            if(i == array[count] - 1) {
                result = result.substring(1, result.length() - array[count] == 4 ? 0 : array[count] == 5 ? 1 : 2);

                if(!map.get(array[count]).equals("")) {
                    result = result.concat(map.get(array[count]));
                }
                count++;
                continue;
            }
            result = result.concat("I");
        }

        System.out.println(nb + " = " + result);
    }
    */
}