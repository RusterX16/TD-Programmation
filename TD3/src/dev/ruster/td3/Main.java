package dev.ruster.td3;

import dev.ruster.td3.ex.*;

import java.util.Scanner;

public class Main {

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
                case 1 -> new ArrayProcess(scan);
                case 2 -> new TreeNumberMax(scan);
                case 3 -> new NumberComponent(scan);
                case 4 -> new NumberFrequency(scan);
                case 5 -> new Palindrome(scan);
                case 6 -> new SimplePyramid(scan);
                case 7 -> new ComplexPyramid(scan);
                case 8 -> new SyracuseNumber(scan);
                case 9 -> new Exponential(scan);
            }
        }
    }
}