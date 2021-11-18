package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record ComplexPyramid(Scanner scan) {

    public ComplexPyramid(@NotNull final Scanner scan) {
        this.scan = scan;

        /*
        System.out.println("Ordre Coissant : ");
        displayCroissantNumbers(scan.nextInt(), scan.nextInt());

        System.out.println("Ordre Pain au chocolat : ");
        displayDecreasesNumbers(scan.nextInt(), scan.nextInt());
        */

        pyramid(scan.nextInt());
        System.out.println();
    }

    public static int @NotNull [] getUnitBand(int n1, int n2, boolean inverted) {
        int[] array = new int[10];
        n1 = NumberComponent.getNumberUnit(n1);
        n2 = NumberComponent.getNumberUnit(n2);
        int z = 0;

        while(n1 != n2 + 1) {
            if(n1 > 9) {
                n1 = 0;
            }
            array[z] = n1;
            n1++;
            z++;
        }

        int[] output = Arrays.copyOf(array, z);
        int[] reversed = new int[z];

        for(int i = 0; i < z; i++) {
            reversed[z - i - 1] = output[i];
        }
        return inverted ? reversed : output;
    }

    public void displayCroissantNumbers(int n1, int n2) {
        if(n1 <= n2) {
            System.out.println(Arrays.toString(getUnitBand(n1, n2, false)));
        }
    }

    public void displayDecreasesNumbers(int n1, int n2) {
        if(n1 <= n2) {
            System.out.println(Arrays.toString(getUnitBand(n1, n2, true)));
        }
    }

    public void pyramid(int n) {
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j += 2) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}