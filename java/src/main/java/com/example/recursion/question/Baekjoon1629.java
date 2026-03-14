package com.example.recursion.question;

import java.util.Scanner;

public class Baekjoon1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        System.out.println(recur(a, b, c));
    }

    private static long recur(long a, long b, long c) {
        if (b == 1) { return a % c; }
        long val = recur(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) { return val; }
        return val * a % c;
    }
}
