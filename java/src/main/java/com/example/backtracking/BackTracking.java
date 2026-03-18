package com.example.backtracking;

public class BackTracking {
    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void backtrack(int depth) {
        // 종료 조건 (Base Case)
        if (depth == M) {
            // 추가로 처리할 것
            return;
        }

        // 하위 단계 탐색
        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {

                visited[i] = true;
                result[depth] = i;

                // 재귀 호출
                backtrack(depth + 1);

                visited[i] = false;
            }
        }
    }
}

