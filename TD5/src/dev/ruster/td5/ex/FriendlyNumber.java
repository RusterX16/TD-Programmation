package dev.ruster.td5.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public record FriendlyNumber(Scanner scan) {

    public FriendlyNumber(@NotNull final Scanner scan) {
        this.scan = scan;

//        System.out.println(areFriends(220, 284));
        displayFriendsNumbers(100000);
        System.out.println();
    }

    public boolean areFriends(int p, int q) {
        return getDivisorsSum(p) == q && getDivisorsSum(q) == p;
    }

    public void displayFriendsNumbers(int range) {
        System.out.println("Les couples d'amis de 0 à " + range + " sont : ");

        for(int i = 1; i <= range; i++) {
            for(int j = 1; j < range; j++) {
                if(areFriends(i, j)) {
                    System.out.println(i + " - " + j);
                }
            }
        }
    }

    private int getDivisorsSum(int v) {
        int sum = 0;

        for(int i = 0; i < v; i++) {
            if(i == 0) {
                continue;
            }
            if(v % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}