package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

import java.util.Random;

public class Main
{
  public static void main(String[] args)
  {

    HastaneUygulama hrs = new HastaneUygulama(new Tarih("22/01/2022 08:00",false));
    hrs.maxHastanelerBelirle(10);

    hrs.hastanelerBelirle(loadTestData());

    menu();

    int kullanciGiris = -1;

    while (kullanciGiris != 0)
    {
      kullanciGiris = hrs.sayiGirisAl("-------------\nBir seçenek secin");

      switch (kullanciGiris)
      {
        case 1:
        {
          hrs.listeleme(hrs.hastanelerAl());
          break;
        }
        case 2:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          hrs.detaylariYazdir(hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin")));
          break;
        }
        case 3:
        {
          if (hrs.hastanelerAl().boyut() > 0)
          {
            hrs.listeleme(hrs.hastanelerAl());
          }
          Hastane yeniHastane = new Hastane();
          System.out.println("Lütfen hastane Bilgileri girin:");

          yeniHastane.adiBelirle(new YeniDizi(hrs.diziGirisAl("Hastane adi")));
          yeniHastane.maxKliniklerBelirle(hrs.sayiGirisAl("Hastane max klinikler sayisi"));

          hrs.hastaneEkle(yeniHastane);

          if (hrs.islemDurumu()) System.out.println("Yeni hastane başarıyla eklendi");

          break;
        }
        case 4:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }

          hrs.listeleme(hrs.hastanelerAl());

          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane != null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
          }

          hrs.hastaneSil(hastane);

          System.out.println("seçtiniz hastane başarıyla silindi");
          break;
        }
        case 5:
        {
          if(hrs.hastanelerAl().boyut() > 0){
            hrs.listeleme(hrs.hastanelerAl());
            Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));
            if(hastane != null){
              hrs.listeleme(hastane.kliniklerAl());
            } else
            {
              System.out.println("Girdiğiniz ID geçersiz");
            }
          }else {
            System.out.println("Sistemde hastane bulunamadı");
          }
          break;
        }
        case 6:
        {
          if(hrs.hastanelerAl().boyut() == 0){
            System.out.println("Sistemde hastane bulunamadı");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));
          if(hastane == null){
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if(klinik == null){
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hrs.detaylariYazdir(klinik);
          break;
        }
        case 7:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));
          if(hastane == null){
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          System.out.println("Lütfen Klinik Bilgileri girin:");

          Klinik yeniKlinik = new Klinik();
          yeniKlinik.adBelirle(new YeniDizi(hrs.diziGirisAl("Klinik adi")));
          yeniKlinik.maxDoktorlarBelirle(hrs.sayiGirisAl("Klinik max doktorlar sayisi"));
          yeniKlinik.maxHastalarBelirle(hrs.sayiGirisAl("Klinik max hastalar sayisi"));
          yeniKlinik.maxRandevularBelirle(hrs.sayiGirisAl("Klinik max randevular sayisi"));

          hastane.klinikEkle(yeniKlinik);

          if (hastane.islemDurumu()) System.out.println("Yeni hastane başarıyla eklendi");

          break;
        }
        case 8:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          hrs.listeleme(hastane.kliniklerAl());

          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if(klinik == null){
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hastane.klinikSil(klinik);

          System.out.println("seçtiniz klinik başarıyla silindi");
          break;
        }
        case 9:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          Liste hasatalerListe = new Liste(new Hasta());

          for (int i = 0; i < hastane.kliniklerAl().boyut(); i++)
          {
            Klinik klinik = (Klinik) hastane.kliniklerAl().al(i);
            for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
            {
              Hasta hasta = (Hasta) klinik.hastalarAl().al(j);

              if (hasta != null) hasatalerListe.ekle(hasta);
            }
          }

          if(hasatalerListe.boyut() == 0 ){
            System.out.println("Hastalar bulunmadi");
            break;
          }

          hrs.listeleme(hasatalerListe);

          break;
        }
        case 10:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          Liste hasatalerListe = new Liste(new Hasta());

          for (int i = 0; i < hastane.kliniklerAl().boyut(); i++)
          {
            Klinik klinik = (Klinik) hastane.kliniklerAl().al(i);
            for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
            {
              Hasta hasta = (Hasta) klinik.hastalarAl().al(j);

              if (hasta != null) hasatalerListe.ekle(hasta);
            }
          }

          if(hasatalerListe.boyut() == 0 ){
            System.out.println("Hastalar bulunmadi");
            break;
          }

          hrs.listeleme(hasatalerListe);

          Hasta hasta = hastane.hastaAl(hrs.sayiGirisAl("Bir hasta seçmek için, ID girin"));

          if (hasta == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hrs.detaylariYazdir(hasta);
          break;
        }
        case 11:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          Hasta yeniHasta = new Hasta();
          System.out.println("Yeni hasta bilgileri girin:");
          yeniHasta.adBelirle(new YeniDizi(hrs.diziGirisAl("Hasta adi:")));
          yeniHasta.yasBelirle(hrs.sayiGirisAl("Hasta yasi"));
          yeniHasta.telefoneBelirle(hrs.diziGirisAl("Hasta telefonu"));

          klinik.hastaEkle(yeniHasta);

          if (klinik.islemDurumu()) System.out.println("Yeni hasta başarıyla eklendi");
          break;
        }
        case 12:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));

          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          if(klinik.hastalarAl().boyut() == 0)
          {
            System.out.println("klinikte hasta bulunamadı");
            break;
          }

          hrs.listeleme(klinik.hastalarAl());
          Hasta hasta = klinik.hastaAl(hrs.sayiGirisAl("Bir hasta seçmek için, ID girin"));

          if (hasta == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          klinik.hastaSil(hasta);

          System.out.println("Seçilen hasta başarıyla silindi");
          break;
        }
        case 13:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          Liste bulunmusHastalar = hastane.hastaArama(new YeniDizi(hrs.diziGirisAl("Hasta adi girin")));

          if(bulunmusHastalar.boyut() == 0){
            System.out.println("hasta bulunamadı");
            break;
          }

          hrs.listeleme(bulunmusHastalar);
          break;
        }
        case 14:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          System.out.println("Hata bilgileri girin:");
          char ilkHarf = hrs.diziGirisAl("Hastanın adının ilk harfini girin, (herhangi bir harf için * girin)").charAt(0);
          char sonHarf = hrs.diziGirisAl("Hastanın adının son harfini girin, (herhangi bir harf için * girin)").charAt(0);
          YeniDizi icerir = new YeniDizi(hrs.diziGirisAl("Hastanın adının bir kısmını girin"));

          Liste bulunmusHastalar = hastane.hastaArama(icerir,ilkHarf,sonHarf);

          if(bulunmusHastalar.boyut() == 0){
            System.out.println("hasta bulunamadı");
            break;
          }
          hrs.listeleme(bulunmusHastalar);
          break;
        }
        case 15:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          Hasta hasta = hastane.enyYuksekHastaRandevu();
          if(hasta != null){
            hrs.detaylariYazdir(hasta);
          }
          break;
        }
        case 16:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hrs.listeleme(hastane.doktorlarAl());
          break;
        }
        case 17:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          Liste doctorlar = hastane.doktorlarAl();
          hrs.listeleme(doctorlar);

          int doctorId = hrs.sayiGirisAl("Bir doctor seçmek için, ID girin");

          for (int i = 0; i < doctorlar.boyut(); i++)
          {
            Doktor doktor = (Doktor) doctorlar.al(i);
            if (doktor.idAl() == doctorId){
              hrs.detaylariYazdir(doktor);
              break;
            }
          }
          break;
        }
        case 18:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));

          Doktor yeniDoktor = new Doktor();
          System.out.println("Yeni doktor bilgileri girin:");
          yeniDoktor.klinikBelirle(klinik);
          yeniDoktor.adBelirle(new YeniDizi(hrs.diziGirisAl("Doktor adi:")));
          yeniDoktor.yasBelirle(hrs.sayiGirisAl("Doktor yasi"));
          yeniDoktor.telefoneBelirle(hrs.diziGirisAl("Doktor telefonu"));

          klinik.doktorEkle(yeniDoktor);

          if (klinik.islemDurumu()) System.out.println("Yeni doktor başarıyla eklendi");
          break;
        }
        case 19:
        {

          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));

          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          if(klinik.doktorlarAl().boyut() == 0)
          {
            System.out.println("klinikte doktor bulunamadı");
            break;
          }

          hrs.listeleme(klinik.doktorlarAl());
          Doktor doktor = klinik.doktorAl(hrs.sayiGirisAl("Bir doktor seçmek için, ID girin"));

          if (doktor == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          klinik.doktorSil(doktor);

          System.out.println("Seçilen doktor başarıyla silindi");
          break;
        }
        case 20:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          Doktor doktor = hastane.enyYuksekDoktorHastalar();
          if(doktor != null){
            hrs.detaylariYazdir(doktor);
          }
          break;
        }
        case 21:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hrs.listeleme(hastane.randevularAl());
          break;
        }
        case 22:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          hrs.listeleme(hastane.randevularAl());
          Liste randevuLar = hastane.randevularAl();
          hrs.listeleme(randevuLar);

          int randevuId = hrs.sayiGirisAl("Bir doctor seçmek için, ID girin");

          for (int i = 0; i < randevuLar.boyut(); i++)
          {
            Randevu randevu = (Randevu) randevuLar.al(i);
            if (randevu.idAl() == randevuId){
              hrs.detaylariYazdir(randevu);
              break;
            }
          }
          break;
        }
        case 23:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }

          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(klinik.doktorlarAl().boyut() == 0)
          {
            System.out.println("Önce bir Doktor eklemelisiniz");
            break;
          }
          if(klinik.hastalarAl().boyut() == 0)
          {
            System.out.println("Önce bir Hasta eklemelisiniz");
            break;
          }

          Randevu yeniRandevu = new Randevu();
          System.out.println("Yeni randevu bilgileri girin:");

          yeniRandevu.klinikBelirle(klinik);

          yeniRandevu.tarihBelirle(new Tarih(hrs.diziGirisAl("(GG/AA/YYYY SS:MM) biçiminde bir tarih girin"),false));

          hrs.listeleme(klinik.doktorlarAl());
          Doktor doktor = klinik.doktorAl(hrs.sayiGirisAl("Bir doktor seçmek için, ID girin"));
          if (doktor == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          yeniRandevu.doktorBelirle(doktor);

          hrs.listeleme(klinik.hastalarAl());
          Hasta hasta = klinik.hastaAl(hrs.sayiGirisAl("Bir hasta seçmek için, ID girin"));
          if (hasta == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          yeniRandevu.hastaBelirle(hasta);
          yeniRandevu.durumBelirle(new YeniDizi("gelecek"));

          klinik.randevuEkle(yeniRandevu);

          if (klinik.islemDurumu()) System.out.println("Yeni randevu başarıyla eklendi");
          break;
        }
        case 24:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(klinik.randevularAl().boyut() == 0)
          {
            System.out.println("Önce bir Doktor eklemelisiniz");
            break;
          }
          hrs.listeleme(klinik.randevularAl());
          Randevu randevu = klinik.randevuAl(hrs.sayiGirisAl("Bir randevu seçmek için, ID girin"));

          klinik.randevuSil(randevu);

          System.out.println("Seçilen randevu başarıyla silindi");
          break;
        }
        case 25:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          Tarih tarih = new Tarih(hrs.diziGirisAl("(GG/AA/YYYY SS:MM) biçiminde bir tarih girin"),true);

          klinik.randevuMusaitligiArama(tarih);
          break;
        }
        case 26:
        {
          if (hrs.hastanelerAl().boyut() == 0){
            System.out.println("Önce bir hastane eklemelisiniz");
            break;
          }
          hrs.listeleme(hrs.hastanelerAl());
          Hastane hastane = hrs.hastaneAl(hrs.sayiGirisAl("Bir hastane seçmek için, ID girin"));

          if (hastane == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }

          if(hastane.kliniklerAl().boyut() == 0)
          {
            System.out.println("Hastanede klinik bulunamadı");
            break;
          }
          hrs.listeleme(hastane.kliniklerAl());
          Klinik klinik = hastane.klinikAl(hrs.sayiGirisAl("Bir klinik seçmek için, ID girin"));
          if (klinik == null)
          {
            System.out.println("Girdiğiniz ID geçersiz");
            break;
          }
          break;
        }
        case 27:
        {
          break;
        }
        case 28:
        {
          System.out.println("durum:" + hrs.islemDurumu());
          System.out.println("durum:" + hrs.hastanelerAl().boyut());
          break;
        }
        case 99:
        {
          menu();
          break;
        }
      }
    }
  }
  public static void menu()
  {
    System.out.println("******************* Hastane randevuları sistemi *************");
    System.out.println("*  0. çıkış                                                 *");
    System.out.println("*  99. Menüsü yazdir                                        *");
    System.out.println("*->>>>>>>>>>>>>>>>>>>>>>>>>>>> Hastane <<<<<<<<<<<<<<<<<<<<-*");
    System.out.println("*  1. Hastaneler listeleme                                  *");
    System.out.println("*  2. Hastane bilgiler listeleme                            *");
    System.out.println("*  3. Yeni hastane ekle                                     *");
    System.out.println("*  4. Hastane sil                                           *");
    System.out.println("*->>>>>>>>>>>>>>>>>>>>>>>>>>>>> Klinik <<<<<<<<<<<<<<<<<<<<-*");
    System.out.println("*  5. Klinikler listeleme                                   *");
    System.out.println("*  6. Klinik bilgiler listeleme                             *");
    System.out.println("*  7. Yeni klinik ekle                                      *");
    System.out.println("*  8. Klinik sil                                            *");
    System.out.println("*->>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hasta <<<<<<<<<<<<<<<<<<<<<-*");
    System.out.println("*  9. Hastalar listeleme                                    *");
    System.out.println("*  10. Hasta bilgiler listeleme                             *");
    System.out.println("*  11. Yeni Hasta ekle                                      *");
    System.out.println("*  12. Hasta sil                                            *");
    System.out.println("*  13. Hasta arama                                          *");
    System.out.println("*  14. hasta detaylı arama                                  *");
    System.out.println("*  15. En fazla randevu alan hasta bilgiler                 *");
    System.out.println("*->>>>>>>>>>>>>>>>>>>>>>>>>>>>> Doktor <<<<<<<<<<<<<<<<<<<<-*");
    System.out.println("*  16. Doktorlar listeleme                                  *");
    System.out.println("*  17. Doktor bilgiler listeleme                            *");
    System.out.println("*  18. Doktor ekle                                          *");
    System.out.println("*  19. Doktor sil                                           *");
    System.out.println("*  20. En yüksek hasta sayısına sahip doktor                *");
    System.out.println("*->>>>>>>>>>>>>>>>>>>>>>>>>>>>> Randevu <<<<<<<<<<<<<<<<<<<-*");
    System.out.println("*  21. Randevular listeleme                                 *");
    System.out.println("*  22. Randevu bilgiler listeleme                           *");
    System.out.println("*  23. Yeni Randevu ekle                                    *");
    System.out.println("*  24. Randevuyu iptal et                                   *");
    System.out.println("*  25. Randevu müsaitliğini kontrol et                      *");
    System.out.println("*  26. Tamamlanmış Randevuların belirli bir dönemde arama   *");
    System.out.println("*  25. Tamamlanmanmış ve gelecektaki Randevuların           *");
    System.out.println("*      belirli bir dönemde arama                            *");
    System.out.println("*************************************************************");
  }

  public static Liste loadTestData()
  {
    Liste hastaneler = new Liste(new Hastane());

    for (int i = 0; i < 2; i++)
    {
      Hastane hastane = new Hastane();

      hastane.adiBelirle(new YeniDizi("Istanbul hastansi " + i));
      hastane.maxKliniklerBelirle(15);

      for (int j = 0; j < 1; j++)
      {
        Klinik klinik = new Klinik();

        klinik.adBelirle(new YeniDizi("Urologie " + j));

        klinik.maxHastalarBelirle(40);
        klinik.maxDoktorlarBelirle(10);
        klinik.maxRandevularBelirle(400);

        for (int k = 0; k < 10; k++)
        {
          Hasta hasta = new Hasta();
          hasta.adBelirle(new YeniDizi("John sina " + k));
          hasta.yasBelirle(k+1);
          hasta.telefoneBelirle("+49-162-982-4544");

          klinik.hastaEkle(hasta);
        }


        for (int k = 0; k < 10; k++)
        {
          Doktor doktor = new Doktor();
          doktor.adBelirle(new YeniDizi("Amro diab " + k));
          doktor.yasBelirle(k+1);
          doktor.klinikBelirle(klinik);
          doktor.telefoneBelirle("+49-162-982-4544");

          klinik.doktorEkle(doktor);
        }

        for (int k = 0; k < 10; k++)
        {
          Randevu randevu = new Randevu();
          randevu.tarihBelirle(new Tarih("20/12/2022 10:30",false));
          randevu.klinikBelirle(klinik);
          Hasta hasta = (Hasta) klinik.hastalarAl().al(0);
          randevu.hastaBelirle(hasta);
          Doktor doktor = (Doktor) klinik.doktorlarAl().al(0);
          randevu.doktorBelirle(doktor);
          String[] st = new String[]{"gelecek", "tamamlandi", "tamamlanmamis"};
          randevu.durumBelirle(new YeniDizi(st[new Random().nextInt(st.length)]));
          klinik.randevuEkle(randevu);
        }

        hastane.klinikEkle(klinik);
      }
      hastane.idBelirle(hastaneler.idAl());
      hastaneler.ekle(hastane);
    }

    return hastaneler;
  }

}
