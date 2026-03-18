package com.example.backtracking.question;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1182 {
    static int N;
    static int S;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        S = input.nextInt();
        input.nextLine();

        arr = Arrays.stream(input.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        backtracking(0, 0);
        if (S == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    static void backtracking(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        backtracking(index + 1, sum +  arr[index]);
        backtracking(index + 1, sum);
    }
}
