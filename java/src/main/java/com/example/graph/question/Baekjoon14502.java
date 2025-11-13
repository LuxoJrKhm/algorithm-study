package com.example.graph.question;

import java.util.*;

// BFS
public class Baekjoon14502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[row][column];
        List<int[]> emptySpace = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 0) emptySpace.add(new int[]{i, j});
            }
        }

        int maxSafeZone = 0;
        for (int i = 0; i < emptySpace.size() - 2; i++) {
            for (int j = i + 1; j < emptySpace.size() - 1; j++) {
                for  (int k = j + 1; k < emptySpace.size(); k++) {
                    int[][] tempGrid = new int[row][column];
                    for(int r = 0; r < row; r++) {
                        for(int c = 0; c < column; c++) {
                            tempGrid[r][c] = grid[r][c];
                        }
                    }
                    tempGrid[emptySpace.get(k)[0]][emptySpace.get(k)[1]] = 1;
                    tempGrid[emptySpace.get(j)[0]][emptySpace.get(j)[1]] = 1;
                    tempGrid[emptySpace.get(i)[0]][emptySpace.get(i)[1]] = 1;
                    maxSafeZone = Math.max(maxSafeZone, search(tempGrid, row, column));
                }
            }
        }

        System.out.println(maxSafeZone);

    }

    private static int search(int[][] grid, int row, int column) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column) { continue; }
                if (grid[nx][ny] != 0) { continue; }

                grid[nx][ny] = 2;
                queue.offer(new int[]{nx, ny});
            }
        }
        int safeZone = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) { safeZone++; }
            }
        }
        return safeZone;
    }
}
