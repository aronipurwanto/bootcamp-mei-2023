package com.bootcamp.polymorphism;

import com.bootcamp.polymorphism.logic03.Logic03Soal09;
import com.bootcamp.polymorphism.logic03.Logic03Soal13;

import java.util.Scanner;

public class MainLogic03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan nilai n : ");
        int n = scanner.nextInt();

        System.out.println("\nLogic 03 Soal no 13");
        SoalLogic soal = new Logic03Soal13(n);
        soal.cetakArray();
    }
}
