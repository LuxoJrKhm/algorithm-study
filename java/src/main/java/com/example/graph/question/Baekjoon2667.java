package com.example.graph.question;

import java.util.*;

public class Baekjoon2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[row][];
        for (int i = 0; i < row; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        List<Integer> list = findPoints(row, board);

        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    public static int search(int row, int[] startPoint, int[][] board, int[][] visited) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Deque<int[]> queue = new ArrayDeque<>();

        int result = 1;

        visited[startPoint[0]][startPoint[1]] = 1;
        queue.offer(new int[]{startPoint[0], startPoint[1]});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= row) { continue; }
                if (visited[nx][ny] != 0 || board[nx][ny] == 0) { continue; }

                result += 1;
                visited[nx][ny] = 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return result;
    }

    public static List<Integer> findPoints(int row, int[][] board) {
        List<Integer> complexList = new ArrayList<>();

        int[][] visited = new int[row][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == 0 || visited[i][j] == 1) { continue; }
                complexList.add(search(row, new int[]{i, j}, board, visited));
            }
        }

        Collections.sort(complexList);

        return complexList;
    }
}
