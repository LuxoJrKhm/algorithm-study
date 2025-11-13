package com.example.graph.question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

// BFS
public class Baekjoon2178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[row][];
        for (int i = 0; i < row; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(search(row, col, board));
    }

    public static int search(int row, int column, int[][] board) {
        int[][] dist = new int[row][column];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Deque<int[]> queue = new ArrayDeque<>();

        dist[0][0] = 1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column) { continue; }
                if (dist[nx][ny] > 0 || board[nx][ny] == 0) { continue; }

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        return dist[row - 1][column - 1];
    }
}
