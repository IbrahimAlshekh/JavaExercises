package com.alshekh.JavaExcercises.LoopOverLinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Solution1
{

  public static void islemleri_bastir(){
    System.out.println("0 - İslemleri görüntüle..");
    System.out.println("1 - Bir sonraki şehre git...");
    System.out.println("2 - Bir önceki şehre git...");
    System.out.println("3 - Uygulamadan çıkk.");
  }

  public static void  sehirleri_turla(LinkedList<String> sehirler) {
    ListIterator<String> iterator = sehirler.listIterator();

    if (!iterator.hasNext()) System.out.println("Herhangi bir şehir bulunmuyor...");

    int islem;

    islemleri_bastir();

    Scanner scanner = new Scanner(System.in);

    boolean cikis = false;

    while (!cikis) {

      System.out.println("Bir işlem seçiniz:");

      islem = scanner.nextInt();

      if(islem == 0){

        islemleri_bastir();

      }else if(islem == 1){

        if (!iterator.hasNext()) System.out.println("Şehir Turu Bitiş noktasında....");

        while (iterator.hasNext()){
          System.out.println("Şehre gidiliyor : " + iterator.next());
          break;
        }

      }else if(islem == 2){

        if (!iterator.hasPrevious()) System.out.println("Şehir Turu Başlangıç noktasında....");

        while (iterator.hasPrevious()){

          System.out.println("Şehre gidiliyor : " + iterator.next());
          break;
        }

      }else if(islem == 3){

        cikis = true;

        System.out.println("Uygulamadan çıkılıyor...");

      }

    }

  }
  public static void main(String[] args) {

    LinkedList<String> sehirler = new LinkedList<>();
    sehirler.add("Ankara");
    sehirler.add("Eskişehir");
    sehirler.add("Afyon");
    sehirler.add("İstanbul");
    sehirleri_turla(sehirler);

  }
}
