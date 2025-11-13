package com.example.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DepthFirstSearch {
    // Template 함수
    public static void search(int row, int column, int[][] board) {
        // 방문 검사 보드
        int[][] visited = new int[row][column];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // visit할 좌표를 넣는 스택
        Deque<int[]> stack = new ArrayDeque<>();

        // 시작점
        visited[0][0] = 1;
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // board를 안 벗어났는지 검사
                if (nx < 0 || nx >= row || ny < 0 || ny >= column) { continue; }
                // 방문을 했거나 board에서 더 이상 방문할 필요가 없는 자리인지 검사
                if (visited[nx][ny] != 0 || board[nx][ny] != 1) { continue; }

                // 방문 표시 후 스택에 넣고 반복
                visited[nx][ny] = visited[nx][ny] + 1;
                stack.push(new int[]{nx, ny});
            }
        }
    }
}
