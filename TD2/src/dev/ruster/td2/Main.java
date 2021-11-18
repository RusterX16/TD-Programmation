package dev.ruster.td2;

import org.jetbrains.annotations.NotNull;

import java.time.Month;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.print("Choisi un exercice : ");
            int choice = scan.nextInt();

            switch(choice) {
                case 0 -> {
                    System.out.println("Merci ! Au revoir !");
                    System.exit(0);
                }
                case 1 -> poker();
                case 2 -> even_numbers_count();
                case 3 -> max_value();
                case 4 -> polynomial_squares_degree_2();
                case 5 -> polynomial_squares_degree_3();
                case 6 -> reading();
                case 7 -> closer_sum();
                case 8 -> bisect_year();
            }
        }
    }

    public static void poker() {
        int score = 0;

        System.out.print("A : ");
        int a = scan.nextInt();
        System.out.print("B : ");
        int b = scan.nextInt();
        System.out.print("C : ");
        int c = scan.nextInt();
        System.out.print("D : ");
        int d = scan.nextInt();
    }

    public static void even_numbers_count() {
        int n, count = 0;

        do {
            System.out.print("Saisir une valeur : ");
            n = scan.nextInt();

            if(n % 2 == 0) {
                count++;
            }
        } while(n != 0);

        System.out.println("Parmis les nombres que vous avez énuméré, il y a " + (count - 1) + " nombres paires");
    }

    public static void max_value() {
        int max = 0;

        for(int i = 0; i < 20; i++) {
            System.out.print((i + 1) + "° valeur : ");
            int n = scan.nextInt();

            if(n > max) {
                max = n;
            }
        }
        System.out.println("La plus grande valeur est » " + max);
    }

    public static void polynomial_squares_degree_2() {
        System.out.print("Valeur de a : ");
        double a = scan.nextDouble();
        System.out.print("Valeur de b : ");
        double b = scan.nextDouble();
        System.out.print("Valeur de c : ");
        double c = scan.nextDouble();

        double delta = b * b - 4 * a * c;

        if(delta < 0) {
            System.out.println("Aucune solution réelle");
            return;
        }
        double t = 0, t1 = 0, t2 = 0;

        if(a != 0) {
            if(delta == 0) {
                t = -b / 2 * a;
            } else {
                t1 = (-b - Math.sqrt(delta)) / (2 * a);
                t2 = (-b + Math.sqrt(delta)) / (2 * a);
            }
        } else t = -c;

        System.out.println("Les solutions de l'équation du second degré " +
                a + "x² + " + b + "x + " + c + (delta > 0 || a != 0 ? " sont " +
                Math.round(t1 * 100.0) / 100.0 + " et " +
                Math.round(t2 * 100.0) / 100.0 : " est " +
                Math.round(t * 100.0) / 100.0)
        );
    }

    public static void polynomial_squares_degree_3() {
        int count = 0;

        System.out.print("Valeur de a : ");
        double a = 1; //scan.nextDouble();
        System.out.print("Valeur de b : ");
        double b = -3; //scan.nextDouble();
        System.out.print("Valeur de c : ");
        double c = 1; //scan.nextDouble();
        System.out.print("Valeur de d : ");
        double d = 1; //scan.nextInt();

        System.out.println("Voici les solutions de " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d + " :");
        for(int i = -3; i <= 3; i++) {
            if(count >= 3) {
                break;
            }
            double result = i * Math.pow(a, 3) + i * Math.pow(b, 2) + i * c + d;
            System.out.println(result);
            boolean equals = Util.round(result, 3) == 0;

            if(equals) {
                System.out.println("» " + i);
                count++;
            }
        }
    }

    public static void reading() {

    }

    public static void closer_sum() {
        boolean overflow = false;
        int sum = 0;
        int z = 0;
        int nb;

        do {
            System.out.print("nb : ");
            nb = scan.nextInt();
        } while(nb <= 0);

        while(!overflow) {
            z++;
            sum += z;

            if(sum > nb) {
                overflow = true;
                sum = nb;
            }
        }
        System.out.println("sum = " + sum);
    }

    public static void bisect_year() {
        System.out.print("Donne moi une année : ");
        int year = scan.nextInt();
        boolean bisect = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        System.out.println("Année " + (bisect ? "bissextile" : "non bissextile"));
    }

    public static boolean isBisectYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void date_validity() {
        System.out.print("Ecrire une date sous la forme (j, m, a) : ");
        String date = scan.nextLine();

        String[] content = date.replace("(", "").replace(")", "").split(", ");
        int[] values = new int[content.length];
        boolean correct = true;

        for(int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(content[i]);
        }
        Month month = Month.of(values[1]);

        if(values[0] > month.length(isBisectYear(values[2]))) {
            correct = false;
        }
        if(values[1] < 1 || values[1] > 12) {
            correct = false;
        }
        if(values[2] < 0) {
            correct = false;
        }
        System.out.println(correct ? "vrai" : "faux");
    }

    public static int @NotNull [] scan_date() {
        System.out.print("Ecrire une date sous la forme (j, m, a) : ");
        String date = scan.nextLine();

        String[] content = date.replace("(", "").replace(")", "").split(", ");
        int[] values = new int[content.length];

        for(int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(content[i]);
        }
        return values;
    }

    public static void days_before_years_start() {
        int[] date = scan_date();
        int days = date[0];

        for(int i = 1; i < date[1]; i++) {
            days += Month.of(i).length(isBisectYear(date[2]));
        }
        System.out.println(days + " jours se sont écoulés depuis le début de l'année jusqu'au (" +
                Arrays.toString(date).replace("[", "").replace("]", "") + ")");
    }

    public static void days_between_two_date() {
        int[] date_1 = scan_date();
        int[] date_2 = scan_date();
        int days = 0;

        if(date_1[2] == date_2[2]) {
            if(date_1[1] == date_2[1]) {
                if(date_1[0] != date_2[0]) {
                    int start, end;

                    if(date_1[0] < date_2[0]) {
                        start = date_1[0];
                        end = date_2[0];
                    } else {
                        start = date_2[0];
                        end = date_1[0];
                    }
                    for(int i = start; i < end; i++) {
                        days++;
                    }
                }
            } else {
                if(date_1[0] != date_2[0]) {
                    int start, end;

                    if(date_1[0] < date_2[0]) {
                        start = date_1[0];
                        end = date_2[0];
                    } else {
                        start = date_2[0];
                        end = date_1[0];
                    }
                    for(int i = start; i < end; i++) {
                        days++;
                    }
                }
                int start, end;

                if(date_1[1] < date_2[1]) {
                    start = date_1[1];
                    end = date_2[1];
                } else {
                    start = date_2[1];
                    end = date_1[1];
                }
                for(int i = start; i < end; i++) {
                    days += Month.of(i).length(isBisectYear(date_1[2]));
                }
            }
        } else {
            int start, end;

            if(date_1[2] < date_2[2]) {
                start = date_1[2];
                end = date_2[2];
            } else {
                start = date_2[2];
                end = date_1[2];
            }
        }
        System.out.println(days);
    }
}