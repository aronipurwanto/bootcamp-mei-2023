package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic03Soal01 extends BaseLogic implements SoalLogic {
    public Logic03Soal01(int n, int m) {
        super(n, m);
    }

    @Override
    public void isiArray() {
        int angka = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if(i>= j){
                    if(i%2 == 0)
                        this.array[i][j] = angka+"";
                    else {
                        int geser = this.n-1-i;
                        this.array[i][this.m - 1 - j - geser] = angka+"";
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
