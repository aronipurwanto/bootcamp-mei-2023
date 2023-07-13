package com.bootcamp.polymorphism.logic03;

import com.bootcamp.polymorphism.BaseLogic;
import com.bootcamp.polymorphism.SoalLogic;

import javax.xml.transform.sax.SAXResult;

public class Logic03Soal02 extends BaseLogic implements SoalLogic {
    public Logic03Soal02(int n) {
        super(n, n);
    }

    @Override
    public void isiArray() {
        int angka = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if(i<= j){
                    if(i%2 == 0)
                        this.array[i][j] = String.valueOf(angka);
                    else {
                        this.array[i][this.n - 1 - j] = String.valueOf(angka);
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
