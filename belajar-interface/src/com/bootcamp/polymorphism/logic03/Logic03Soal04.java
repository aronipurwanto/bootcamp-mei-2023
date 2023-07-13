package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic03Soal04 extends BaseLogic implements SoalLogic {
    public Logic03Soal04(int n) {
        super(n, n);
    }

    @Override
    public void isiArray() {
        int angka = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if(i+j >= n-1) {
                    if (i % 2 == 1)
                        this.array[i][j] = String.valueOf(angka);
                    else {
                        int geser = n-1-i;
                        this.array[i][this.n - 1 - j + geser] = String.valueOf(angka);
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
