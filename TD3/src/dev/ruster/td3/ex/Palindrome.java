package dev.ruster.td3.ex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record Palindrome(Scanner scan) {

    public Palindrome(@NotNull final Scanner scan) {
        this.scan = scan;

        System.out.println(isPalindrome(new char[]{'K', 'A', 'Y', 'A', 'K'}));
    }

    @Contract(pure = true)
    public boolean isPalindrome(char @NotNull [] array) {
        int size = array.length;
        char[] output = new char[size];

        for(int i = 0; i < size; i++) {
            output[size - i - 1] = array[i];
        }
        return Arrays.equals(output, array);

        /*
        String str = String.valueOf(array);
        return new StringBuilder(str).reverse().toString().equals(str);
        */
    }
}