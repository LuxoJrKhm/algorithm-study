package com.example.graph.question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

// BFS
public class Baekjoon7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int row = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[row][];
        for (int i = 0; i < row; i++) {
            grid[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(search(grid, row, column));
    }

    private static int search(int[][] grid, int row, int column) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int resultDay = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column) { continue; }
                if (grid[nx][ny] != 0) { continue; }

                grid[nx][ny] = 1;
                queue.offer(new int[]{nx, ny, temp[2] + 1});
            }
            resultDay = Math.max(resultDay, temp[2]);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) { return -1; }
            }
        }
        return resultDay;
    }
}
