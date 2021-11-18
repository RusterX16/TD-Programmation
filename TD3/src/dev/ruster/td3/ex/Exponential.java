package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record Exponential(Scanner scan) {

    public Exponential(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println();
    }

    public double getExponential(int n) {
        return 0.0;
    }
}