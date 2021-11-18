package dev.ruster.td4.ex;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sudoku {

    private final Scanner scan;
    private final Random r;

    public Sudoku(@NotNull final Scanner scan) {
        this.scan = scan;
        r = new Random();

        sudoku(3);
    }

    private void sudoku(int n) {
        int[][] matrix = new int[(int) Math.pow(n, 2)][(int) Math.pow(n, 2)];
        List<Integer> integers = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {

            }
        }
    }
}