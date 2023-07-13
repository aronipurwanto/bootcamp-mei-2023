package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic03Soal05 extends BaseLogic implements SoalLogic {
    public Logic03Soal05(int n) {
        super(n, n);
    }

    @Override
    public void isiArray() {
        int angka = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if(i >= j && i <= n/2) {
                    if(i%2 == 0) {
                        // kiri atas
                        this.array[i][j] = String.valueOf(angka);
                        // kiri bawah
                        this.array[n - 1 - i][j] = String.valueOf(angka);

                        // kanan atas
                        this.array[i][n-1-j] = String.valueOf(angka);
                        // kanan bawah
                        this.array[n-1-i][n-1-j] = String.valueOf(angka);
                    }
                    else {
                        int geser = this.n-1-i;
                        // kiri atas
                        this.array[i][this.n - 1 - j - geser] = String.valueOf(angka);
                        // kiri bawah
                        this.array[n-1-i][this.n - 1 - j - geser] = String.valueOf(angka);

                        // kanan atas
                        this.array[i][geser+j] = String.valueOf(angka);
                        // kanan bawah
                        this.array[n-1-i][geser+j] = String.valueOf(angka);
                    }
                    angka += 2;
                }
            }
        }
    }

    @Override
    public void cetakArray() {
        // panggil isi array
        this.isiArray();
        // panggil cetak array dari Parent
        super.cetakArray();
    }
}
