package com.example.recursion.question;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        bw.write(((1 << n) - 1) + "\n");
        hanoi(n, 1, 3);
        bw.flush();
    }

    private static void hanoi(int n, int dep, int des) throws IOException {
        if (n == 1) {
            bw.write(dep + " " + des + "\n");
            return ;
        }

        int temp = 6 - dep - des;
        hanoi(n - 1, dep, temp);
        bw.write(dep + " " + des + "\n");
        hanoi(n - 1, temp, des);
    }
}
