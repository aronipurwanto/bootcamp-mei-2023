package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic03Soal09 extends BaseLogic implements SoalLogic {
    public Logic03Soal09(int n) {
        super(n, n);
    }

    @Override
    public void isiArray() {
        int nTengah = this.n /2;
        for (int i = 0; i < this.n; i++) {
            int angka = (nTengah*2)+1;
            for (int j = 0; j < this.n; j++) {
                if(i +j >= nTengah && j-i <= nTengah && i <= nTengah) {
                    this.array[i][j] = String.valueOf(angka);
                    this.array[n-1-i][j] = String.valueOf(angka);

                    if(j < nTengah)
                        angka -= 2;
                    else
                        angka+=2;
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
