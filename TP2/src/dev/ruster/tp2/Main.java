package dev.ruster.tp2;

import dev.ruster.tp2.utils.Util;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        menuMarin(scan);
    }

    @Contract(" -> new")
    public static int @NotNull [] scanDimensions() {
        int length, width;

        do {
            System.out.print("Fixer une valeur pour la largeur : ");
            width = scan.nextInt();
        } while(width % 2 == 0);

        do {
            System.out.print("Fixer une valeur supérieur à " + width + " pour la longueur maintenant : ");
            length = scan.nextInt();
        } while(length < width);

        return new int[]{length, width};
    }

    public static int roll() {
        int n = Util.randomIntBetween(1, 100);
        int roll = 0;

        if(n <= 50) {
            return 1;
            //roll = 1;
        }
        if(n <= 70) {
            return 2;
            //roll = 2;
        }
        if(n <= 90) {
            return 3;
            //roll = 3;
        }
        if(n <= 100) {
            return 4;
            //roll = 4;
        }
        return roll;
    }

    public static boolean arivobato(int @NotNull [] dimensions, boolean display) {
        boolean success = false;
        boolean onBoard = true;

        int[] directions = new int[4];
        int distance = dimensions[0];
        int x = dimensions[1] / 2;
        int y = 0;

        while(onBoard) {
            int n = roll();

            if(x < 0 || x >= dimensions[1] || y < 0 || y == distance) {
                if(y == distance) {
                    success = true;
                }
                onBoard = false;
            }

            if(display) {
                System.out.println("Petit pas " + (n == 1 ? "devant" : n == 2 ? "à droite" :
                        n == 3 ? "à gauche" : n == 4 ? "derrière" : "") + "\n");
                displayMarin(dimensions[0], dimensions[1], x, y);
            }

            switch(n) {
                case 1 -> {
                    directions[0]++;
                    y++;
                }
                case 2 -> {
                    directions[1]++;
                    x--;
                }
                case 3 -> {
                    directions[2]++;
                    x++;
                }
                case 4 -> {
                    directions[3]++;
                    y = y > 0 ? y - 1 : y;
                }
            }
        }
        if(display) {
            System.out.println("Vous avez fait " + directions[0] + " pas vers l'avant");
            System.out.println("Vous avez fait " + directions[1] + " pas vers la gauche");
            System.out.println("Vous avez fait " + directions[2] + " pas vers la droite");
            System.out.println("Vous avez fait " + directions[3] + " pas vers l'arrière");
        }
        return success;
    }

    public static String displayMarin(int width, int length, int x, int y) {
        String board = "";

        for(int i = width - 1; i >= 0; i--) {
            for(int j = length - 1; j >= 0; j--) {
                if(i == y && j == x) {
                    board = board.concat("o");
                } else {
                    board = board.concat("_");
                }
            }
            board = board.concat("\n");
        }
        System.out.println(board);

        for(int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        Util.sleep(1250);
        return board;
    }

    public static double probaEmpirique(int[] dimensions, int count) {
        int success = 0;

        for(int i = 0; i < count; i++) {
            if(arivobato(dimensions, false)) {
                success++;
            }
        }
        return success / (double) count;
    }

    public static void afficheProba(int @NotNull [] dimensions, int count) {
        System.out.println("Les probabilités de succès pour " + count + " marins sur une planche de " +
                dimensions[0] + " par " + dimensions[1] + " sont de " + probaEmpirique(dimensions, count));
    }

    public static int largeurMin(int @NotNull [] dimensions, int nbMarins, double probaMin) {
        int minWidth = 0;
        return minWidth;
    }

    public static void menuMarin(@NotNull Scanner scan) {
        while(true) {
            System.out.println("0 : Sortir \n1 : Arivobato \n2 : Proba Empirique");
            System.out.print("Ton choix : ");
            int choice = scan.nextInt();

            switch(choice) {
                case 0 -> {
                    System.out.println("Merci au revoir !");
                    System.exit(0);
                }
                case 1 -> System.out.println(arivobato(scanDimensions(), true) ? "Vous avez réussi !" : "Vous avez échoué...");
                case 2 -> {
                    System.out.print("Combien de marins ? ");
                    int count = scan.nextInt();
                    double pourcentage = probaEmpirique(scanDimensions(), count) * 100;

                    System.out.println("La réussite est de " + ((int) pourcentage == pourcentage ?
                            new DecimalFormat("#").format(pourcentage) : pourcentage) + "%");
                }
            }
            System.out.println();
        }
    }
}