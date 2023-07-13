package com.bootcamp.polymorphism;

public class BaseLogic {
    public int n;
    public int m;
    public String[][] array;

    public BaseLogic(int n, int m) {
        this.n = n;
        this.m = m;
        this.array = new String[n][m];
    }

    public void cetakArray(){
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if(this.array[i][j] == null){
                    System.out.print("\t\t");
                }else {
                    System.out.print(this.array[i][j] + "\t\t");
                }
            }
            System.out.println("\n");
        }
    }
}
