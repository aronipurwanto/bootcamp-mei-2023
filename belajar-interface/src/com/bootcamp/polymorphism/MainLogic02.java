package com.bootcamp.polymorphism;

import com.bootcamp.polymorphism.logic02.*;

import java.util.Scanner;

public class MainLogic02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan nilai n : ");
        int n = scanner.nextInt();

        System.out.println("Logic 02 Soal no 1");
        SoalLogic soal01 = new Logic02Soal01(n);
        soal01.cetakArray();


        System.out.println("\nLogic 02 Soal no 2");
        SoalLogic soal02 = new Logic02Soal02(n);
        soal02.cetakArray();
    }
}
