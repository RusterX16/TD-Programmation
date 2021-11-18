package dev.ruster.td4.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record MagicSquare(Scanner scan) {

    public MagicSquare(Scanner scan) {
        this.scan = scan;

        for(int[] row : magicSquare()) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public int @NotNull [][] magicSquare() {
        int n;

        do {
            System.out.print("Saisir n : ");
            n = scan.nextInt();
        } while(n < 0 || n % 2 == 0);

        int[][] matrix = new int[n][n];
        int last = matrix.length - 1;
        int col = last / 2;
        int row = 0;
        int z = 1;

        Arrays.stream(matrix).forEach(it -> Arrays.fill(it, 0));

        /*
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        */
        matrix[row][col] = z;

        while(z < Math.pow(matrix.length, 2)) {
            row = row <= 0 ? last : row - 1;
            col = col >= last ? 0 : col + 1;

            if(matrix[row][col] != 0) {
                for(int i = 0; i < 2; i++) {
                    row = row >= last ? 0 : row + 1;
                }
                col = col <= 0 ? last : col - 1;
            }
            z++;
            matrix[row][col] = z;
        }

        return matrix;
    }
}