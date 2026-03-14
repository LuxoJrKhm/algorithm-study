package com.example.recursion;

public class Recursive {
    public static void recursive(int n) {
        // Base Case - 없으면 무한 재귀 → Stack Overflow
        if (n <= 0) return;
        // 현재 단계에서 할 작업
        System.out.println(n);

        // Recursive Case - n에서 재귀적으로 Base Case로 가도록
        recursive(n - 1);
    }
}
