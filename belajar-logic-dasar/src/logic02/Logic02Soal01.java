package logic02;

import java.util.Scanner;

public class Logic02Soal01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Angka n : ");
        int n = scanner.nextInt();
        System.out.println("nilai n: "+ n);

        // proses membuat kotak
        for (int a = 0; a < n; a++) {
            int angka = 1;
            for (int i = 0; i < n; i++) {
                System.out.print(angka +"\t");
                angka+=2;
            }
            // pindah baris
            System.out.println();
        }
    }
}
