public class SampleLoop {
    public static void main(String[] args) {
        soal01(5);
    }

    public static void sample01(){
        // membuat variable n tipe datanya int
        // diberi nilai 10
        int n = 10;

        for (int i = 0; i <= n; i+=2){
            // i++ => i = i + 1
            // i+=2  => i = i + 2
            System.out.println("nilai ke "+i);
        }

        for (int j = 0; j <= n; j++) {
            System.out.print(j +"\t");
        }
    }

    public static void soal01(int n){
        int angka = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(angka +"\t");
            angka = angka+2;
        }
    }
}
