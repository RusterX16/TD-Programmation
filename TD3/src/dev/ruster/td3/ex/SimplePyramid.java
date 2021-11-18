package dev.ruster.td3.ex;

import java.util.Scanner;

public record SimplePyramid(Scanner scan) {

    public SimplePyramid(Scanner scan) {
        this.scan = scan;

        /*
        repeatCar(8, '*');
        System.out.println();

        simplePyramid(8, '*');
        System.out.println();
        */
    }

    public void repeatCar(int n, char car) {
        for(int i = 0; i < n; i++) {
            System.out.print(car + " ");
        }
        System.out.println();
    }

    public void simplePyramid(int n, char car) {
        for(int i = 0; i < n; i++) {
            for(int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print(car + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}