package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int num = getNum();

    private static int getNum() {
        int min = 1000;
        int max = 9000;
        return (int) (min + Math.random()*max);
    }

    private static int isCow(int userNum) {
        int cow = 0;
        String user = String.valueOf(userNum);
        String nums = String.valueOf(num);
        for (int i=0; i<nums.length(); i++) {
            String sub = user.substring(i, i+1);
            if (nums.contains(sub)) {
                cow+=1;
            }
        }
        return cow;
    }

    private static int isBull(int userNum) {
        int bull = 0;
        String numer = String.valueOf(num);
        String user = String.valueOf(userNum);
        for (int i=0; i<4; i++) {
            if (user.charAt(i) == numer.charAt(i)) {
                bull+=1;
            }
        }
        return bull;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Привет, пользователь! Итак, я загадаю 4-х значное число, а твоя задача - его угадать. Я буду подсказывать сколько чисел есть в загаданном числе(коровы) \n и сколько чисел на своих местах (быки).");
        Scanner sc = new Scanner(System.in);
        System.out.println(num);
        for (int step = 1; ; step++) {
            int UserNum = sc.nextInt();
            if (UserNum==num) {
                System.out.println("Поздравляем, число угадано! Потрачено: " + step +" ходов.");
                break;
            } else {
                int cow = isCow(UserNum);
                int bull = isBull(UserNum);
                System.out.println("Не угадал, попробуй ещё! У тебя: " + cow + " коров и " + bull + " быков.");
            }
        }
    }
}
