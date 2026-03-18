package com.example.backtracking.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15649 {
    static int N, M;
    static int[] sequence;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        sequence = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int var : sequence) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
