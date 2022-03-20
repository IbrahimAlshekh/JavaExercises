package com.alshekh.JavaExcercises.StudentManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Lütfen bölümlerin sayısını ayarlayın");

        Bolumler bolumler = new Bolumler(ScanIntInput(scanner, "Sayi: "));

        bolumler.SetBolumler();

        //clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int secenek = 0;

        while (secenek != 7){
            System.out.println("==================================================");
            System.out.println("||  1- Tüm Bölümlerin Bilgilerini Listele       ||");
            System.out.println("||  2- Bölüm Adına Göre Arama Yap               ||");
            System.out.println("||  3- Öğrenci Adına Göre Arama Yap             ||");
            System.out.println("||  4- Ders Adına Göre Arama Yap                ||");
            System.out.println("||  5- Sınıf Bilgisine Göre Öğrencileri Bul     ||");
            System.out.println("||  6- Ders Kredisine Göre Dersleri Bul         ||");
            System.out.println("||  7- Çıkış                                    ||");
            System.out.println("==================================================");

            secenek = ScanIntInput(scanner, "menüden bir numara seçin: ");

            switch (secenek) {
                case 1 :
                    System.out.println("----------------------------------------------------");
                    bolumler.BolumlerBilgileriniYazdir(null, true);
                    System.out.println("----------------------------------------------------");
                    break;
                case 2 :
                    System.out.println("----------------------------------------------------");
                    System.out.print("Bölüm Adı: ");
                    String bolumAdi = scanner.next();
                    bolumler.BolumAra(bolumAdi);
                    System.out.println("----------------------------------------------------");
                    break;
                case 3 :
                    System.out.println("----------------------------------------------------");
                    System.out.print("Öğrenci (Adı/Soy Adi/Aid Soy Adi): ");
                    String orgAdi = scanner.next();
                    bolumler.OgrenciAra(orgAdi);
                    System.out.println("----------------------------------------------------");
                    break;
                case 4 :
                    System.out.println("----------------------------------------------------");
                    System.out.print("Ders Adi: ");
                    String dersAdi = scanner.next();
                    bolumler.DersAra(dersAdi);
                    System.out.println("----------------------------------------------------");
                    break;
                case 5 :
                    System.out.println("----------------------------------------------------");
                    int orgSinif = ScanIntInput(scanner, "Öğrenci Sinif: ");
                    bolumler.OgrenciAra(orgSinif);
                    System.out.println("----------------------------------------------------");
                    break;
                case 6 :
                    System.out.println("----------------------------------------------------");
                    int dersKredi = ScanIntInput(scanner, "Ders Kridisine: ");
                    bolumler.DersAra(dersKredi);
                    System.out.println("----------------------------------------------------");
                break;
            }
        }
    }

    public static int ScanIntInput(Scanner sc, String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Girilen değer bir sayı olmalıdır, lütfen tekrar deneyin");
                sc.next();
            }
        }
        return input;
    }
}
