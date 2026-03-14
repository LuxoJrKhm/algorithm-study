package com.example.recursion.question;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon1074 {
    private static Map<List<Integer>, Integer> map = Map.of(
            List.of(0, 0), 0,
            List.of(0, 1), 1,
            List.of(1, 0), 2,
            List.of(1, 1), 3
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(recur(N, r, c));
    }

    private static int recur(int N, int r, int c) {
        if (N == 1) {
            return map.get(List.of(r, c));
        }
        int cur = (int) Math.pow(2, N - 1);
        return  cur * cur * map.get(List.of(
                r / cur, c / cur)) +
                recur(N - 1, r % cur, c % cur);
    }
}
