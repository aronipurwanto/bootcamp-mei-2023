package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic03Soal14 extends BaseLogic implements SoalLogic {
    public Logic03Soal14(int n) {
        super(n, n);
    }

    @Override
    public void isiArray() {
        int angka = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if(i % 2 == 0)
                    this.array[j][i] = String.valueOf(angka);
                else
                    this.array[this.n - 1 - j][i] = String.valueOf(angka);
                angka += 2;
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
