package dev.ruster.td5.ex;

import java.util.Scanner;

public record PerfectSquare(Scanner scan) {

    public PerfectSquare(Scanner scan) {
        this.scan = scan;

//        System.out.println((perfectSquare(16)));
//        System.out.println(isPerfectSquare(27));
        System.out.println(canBeCatheters(3, 4));
        System.out.println();
    }

    public int perfectSquare(int n) {
        return isPerfectSquare(n) ? (int) Math.sqrt(n) : -1;
//        return Math.sqrt(n) % 1 == 0 ? (int) Math.sqrt(n) : -1;
    }

    public boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public boolean canBeCatheters(int n1, int n2) {
        return (Math.sqrt(Math.pow(n1, 2) + Math.pow(n2, 2))) % 1 == 0;
    }
}