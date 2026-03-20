package com.example.dp;

public class BottomUpDP {
    static int n = 100;
    public static void solve(String[] args) {
        long[] dp = new long[n + 1];

        if (n >= 0) dp[0] = 0;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
