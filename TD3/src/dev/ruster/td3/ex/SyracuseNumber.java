package dev.ruster.td3.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record SyracuseNumber(Scanner scan) {

    public SyracuseNumber(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println();
    }

    public boolean isSuracuse(int n) {
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return true;
    }

    public boolean isSuracuse() {
        int n;

        do {
            n = scan.nextInt();
        } while(n <= 0);

        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return true;
    }

    public boolean isSuracuse(int n, int it) {
        boolean surasuse = false;

        for(int i = 1; i < it; i++) {
            if(n == 1) {
                surasuse = true;
                break;
            }
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return surasuse;
    }
}