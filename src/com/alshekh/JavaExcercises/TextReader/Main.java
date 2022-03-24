package com.alshekh.JavaExcercises.TextReader;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {

    EKitap eKitap = new EKitap("Yazilim",new int[]{5,6,7,8,9,10});

    MetinMesaj metinMesaj = new MetinMesaj("Ismail", "Hello World!");

    Scanner scanner = new Scanner(System.in);

    System.out.println("\n++++++++++++++\nTest MetinMesaj getConderen():");
    scanner.nextLine();
    System.out.println("Gonderen: " + metinMesaj.getGinderen());


    System.out.println("\n++++++++++++++\nTest MetinMesaj oku():");
    scanner.nextLine();
    System.out.println("Gonderen: " + metinMesaj.Oku());


    System.out.println("\n++++++++++++++\nTest eKitap getIsim():");
    scanner.nextLine();
    System.out.println("Kitap ismi: " + eKitap.getIsim());

    System.out.println("\n++++++++++++++\nTest eKitap sayfaSayisi():");
    scanner.nextLine();
    System.out.println("Sayfa Sayisi: " + eKitap.sayfaSayisi());


    System.out.println("\n++++++++++++++\nTest eKitap sayfaSayisi():");
    for (int i = 0; i < 10; i++)
    {
      scanner.nextLine();
      System.out.println("Sonraki sayfa: " + eKitap.sonrakiSayfa());
    }



  }
}
