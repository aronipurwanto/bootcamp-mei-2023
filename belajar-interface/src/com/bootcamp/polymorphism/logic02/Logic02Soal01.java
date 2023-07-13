package com.bootcamp.polymorphism.logic02;

import com.bootcamp.polymorphism.SoalLogic;

public class Logic02Soal01 implements SoalLogic {
    private int n;
    private int[][] array;

    public Logic02Soal01(int n) {
        this.n = n;
        this.array = new int[n][n];
    }

    @Override
    public void isiArray() {
        for (int i = 0; i < this.n; i++) {
            int angka = 1;
            for (int j = 0; j < this.n; j++) {
                this.array[i][j] = angka;
                angka+=2;
            }
        }
    }

    @Override
    public void cetakArray() {
        // panggil method isi array
        this.isiArray();
        // cetak array
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(this.array[i][j] +"\t");
            }
            System.out.println("\n");
        }
    }
}
