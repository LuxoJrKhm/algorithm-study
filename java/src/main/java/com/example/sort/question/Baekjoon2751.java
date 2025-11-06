package com.example.sort.question;

import com.example.sort.MergeSort;
import com.example.sort.QuickSort;

import java.io.*;

public class Baekjoon2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(br.readLine());

        // 알고리즘 선택
        // QuickSort, MergeSort
        QuickSort.sort(list,  0, n - 1);

        for (int i = 0; i < n; i++) {
            bw.write(Integer.toString(list[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
