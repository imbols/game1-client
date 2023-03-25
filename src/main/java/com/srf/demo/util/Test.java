package com.srf.demo.util;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 146; i++) {
            int rewardId = i % 30;
            if (i > 0 && rewardId == 0) {
                rewardId = 30;
            }
            System.out.println(i + ", " + rewardId);
        }
    }
}
