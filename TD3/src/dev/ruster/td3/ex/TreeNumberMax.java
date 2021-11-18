package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record TreeNumberMax(Scanner scan) {

    public TreeNumberMax(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(max3(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        System.out.println();
    }

    public int max2(int a, int b) {
        return Math.max(a, b);
    }

    public int max3(int a, int b, int c) {
        if(a > b && a > c) {
            return a;
        } else return Math.max(b, c);
    }
}