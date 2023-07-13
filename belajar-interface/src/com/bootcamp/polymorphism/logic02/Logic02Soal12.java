package com.bootcamp.polymorphism.logic02;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

public class Logic02Soal12 extends BaseLogic implements SoalLogic {
    public Logic02Soal12(int n) {
        super(n,n);
    }

    @Override
    public void isiArray() {
        for (int i = 0; i < this.n; i++) {
            int angka = 2;
            for (int j = 0; j < this.n; j++) {
                if(i>=j && i+j <= n-1) {
                    this.array[i][j] = String.valueOf(angka);
                } else if (i<=j && i+j >= n-1) {
                    this.array[i][j] = String.valueOf(angka);
                }
                angka+=2;
            }
        }
    }

    @Override
    public void cetakArray() {
        // panggil method isi array
        this.isiArray();
        super.cetakArray();
    }
}
