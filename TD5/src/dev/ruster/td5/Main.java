package dev.ruster.td5;

import dev.ruster.td5.ex.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public final class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.print("Choisir un exercice (0 pour quitter) : ");
            int choice = scan.nextInt();

            switch(choice) {
                case 0 -> {
                    System.out.println("Merci ! A la prochaine !");
                    System.exit(0);
                }
                case 1 -> new Multiplication(scan);
                case 2 -> new RomanNumerals(scan);
                case 3 -> new PerfectSquare(scan);
                case 4 -> new FriendlyNumber(scan);
                case 5 -> new NonSignificantCompacting(scan);
                case 6 -> new DuplicateCompacting(scan);
                case 7 -> new LongestTraySearch(scan);
                case 8 -> new MoreFrequentNumber(scan);
            }
        }
    }
}