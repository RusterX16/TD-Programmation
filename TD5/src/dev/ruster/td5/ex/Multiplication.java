package dev.ruster.td5.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record Multiplication(Scanner scan) {

    public Multiplication(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.print("Choisir un nombre : ");
        multiplication(scan.nextInt());
        System.out.println();
    }

    private void multiplication(int n) {
        int length = 10;
        int resultPaddingLength = String.valueOf(length * n).length();

        for(int i = 0; i < length; i++) {
            System.out.println((i + 1) +
                    (" ".repeat(String.valueOf(length).length() - String.valueOf(i + 1).length())) +
                    " * " + n + " = " +
                    (" ".repeat((resultPaddingLength - String.valueOf((i + 1) * n).length()))) +
                    ((i + 1) * n));
        }
    }
}