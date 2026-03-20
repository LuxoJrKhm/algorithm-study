package com.example.dp;

public class TopDownDP {
    static int[] memo = new int[1000];

    public static int solve(int n) {
        if (n <= 1) return n;

        if (memo[n] != -1) return memo[n];

        memo[n] = solve(n - 1) + solve(n - 2);

        return memo[n];
    }
}
