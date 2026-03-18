package com.example.backtracking.question;

import java.util.Scanner;

public class Baekjoon9663 {
    static int N;
    static int[][] isPlaced;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        isPlaced = new int[N][N];

        dfs(0);
        System.out.println(count);
    }

    static void dfs(int st) {
        if (st == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isPlaced[st][i] == 0) {
                for (int j = 1; j < N - st; j++) {
                    isPlaced[st + j][i] += 1;
                    if (i + j < N) {
                        isPlaced[st + j][i + j] += 1;
                    }
                    if (0 <= i - j) {
                        isPlaced[st + j][i - j] += 1;
                    }
                }

                dfs(st + 1);

                for (int j = 1; j < N - st; j++) {
                    isPlaced[st + j][i] -= 1;
                    if (i + j < N) {
                        isPlaced[st + j][i + j] -= 1;
                    }
                    if (0 <= i - j) {
                        isPlaced[st + j][i - j] -= 1;
                    }
                }
            }
        }
    }
}
