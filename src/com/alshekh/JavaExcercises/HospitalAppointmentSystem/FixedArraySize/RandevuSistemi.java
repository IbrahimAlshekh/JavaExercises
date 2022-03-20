package com.alshekh.JavaExcercises.HospitalAppointmentSystem.FixedArraySize;

import java.util.Scanner;

public class RandevuSistemi {
    public static Hastane[] hastaneler;

    public static void main(String[] args) {
        //load test data
        hastaneler = new Hastane[3];
        String gecerliTarih = "2022-06-03 saat:08";
        hastaneler[0] = TestVerileriniYukle(gecerliTarih, 1,"Istanbul");
        hastaneler[1] = TestVerileriniYukle(gecerliTarih, 2,"Izmir");

        // init scanner
        Scanner scanner = new Scanner(System.in);
        menuYazdir();

        while (true) {
            System.out.print("\nBir seçenek belirleyin:");
            int kullaniciGirisi = scanner.nextInt();

            if(kullaniciGirisi == 0) break;
            String hastaAdi = "";
            String doctorAdi = "";
            int klinikId, hastaneId, hastaId, randevuId, doctorId;

            Hastane secilenHastane;
            Klinik secilenKlinik;
            Hasta secilenHasta;
            Doktor secilenDoktor;

            switch (kullaniciGirisi) {
                case 1: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    if( secilenHastane == null) {
                        System.out.println("Hastane bulunmadi");
                        break;
                    }

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSeçmek için Klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);
                        System.out.print("\nRandevu olup olmadığını kontrol etmek için (YYYY-AA-GG) formatında bir tarih girin.");
                        scanner.nextLine();
                        String kontrolEdilecekTarih = scanner.nextLine();
                        if(tarihKarsilastir(kontrolEdilecekTarih,tarihToString(tarihSplit(gecerliTarih),false), false) < 0 ){
                            System.out.println("Girilen tarih geçerli değildir");
                            break;
                        }

                        System.out.println("********************************************");
                        System.out.println("Hastane: " + secilenHastane.getAd());
                        System.out.println("Klinik: " + secilenKlinik.getAd());
                        System.out.println("----------- Musait Doctorlar --------------");
                        secilenKlinik.doktorlarListeleme();
                        System.out.println("----------- Musait Randevularin Belgilerini --------------");
                        int[] tarihDizi = tarihSplit(kontrolEdilecekTarih);
                        for (int j = 9; j < 19; j++){
                            boolean atla = false;
                            for (int i = 0; i < secilenKlinik.getRandevular().length; i++) {
                                if (secilenKlinik.getRandevular()[i] == null) break;
                                if( secilenKlinik.getRandevular()[i].getDurum().equals("gelecek") &&
                                    tarihKarsilastir(tarihDizi[0] +"-" + sifiEkle(tarihDizi[1]) + "-" + sifiEkle(tarihDizi[2]) + " saat:" + sifiEkle(j), secilenKlinik.getRandevular()[i].getTarih(), true) == 0 ){
                                    atla = true;
                                }
                            }
                            if(atla) continue;
                            System.out.println("Tarih: " + tarihDizi[0] +"-" + tarihDizi[1] + "-" + tarihDizi[2] + " saat:" + sifiEkle(j));
                        }
                        System.out.println("********************************************");
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 2: {
                    //print Appointments Info
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();

                    HastaneAyrintilariniYazdir(getHastane(hastaneId));

                    break;
                }
                case 3: {
                    int enYueksekRandevuSayisi = 0;
                    for (int i = 0; i < hastaneler.length; i++) {
                        if (hastaneler[i] == null) break;
                        for (int j = 0; j < hastaneler[i].getKlinikler().length; j++) {
                            if (hastaneler[i].getKlinikler()[j] == null) break;
                            Klinik klinik = hastaneler[i].getKlinikler()[j];
                            for (int k = 0; k < klinik.getHastalar().length; k++) {
                                if (klinik.getHastalar()[k] == null) break;
                                int randevuSayisi = hastaneler[i].getHastaRandevularSayisi(klinik.getHastalar()[k].getAd());
                                if (randevuSayisi > enYueksekRandevuSayisi) {
                                    enYueksekRandevuSayisi = randevuSayisi;
                                    hastaAdi = klinik.getHastalar()[k].getAd();
                                }
                            }
                        }
                    }
                    hastaAyrintilariniYazdir(hastaAdi);
                    break;
                }
                case 4: {
                    //print Patient Info
                    System.out.print("\nHasta adını girin:");
                    scanner.nextLine();
                    hastaAdi = scanner.nextLine();

                    hastaAyrintilariniYazdir(hastaAdi);
                    break;
                }
                case 5: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSeçmek için Klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);
                        secilenKlinik.hastalarListeleme();
                        System.out.print("\nSeçmek için Hasta ID girin:");
                        hastaId = scanner.nextInt();
                        secilenHasta = secilenKlinik.getHasta(hastaId);

                        boolean randevusuVardir = false;
                        for (int i = 0; i < secilenKlinik.getRandevular().length; i++) {
                            if (secilenKlinik.getRandevular()[i] == null) break;
                            if (secilenKlinik.getRandevular()[i].getDurum().equals("gelecek")) {
                                if (secilenHasta == secilenKlinik.getRandevular()[i].getHasta()) {
                                    System.out.println(
                                        "ID: " + secilenKlinik.getRandevular()[i].getId() +
                                        " - Tarih: " + secilenKlinik.getRandevular()[i].getTarih() +
                                        " - Durum: " + secilenKlinik.getRandevular()[i].getDurum() +
                                        " - Klinik: " + secilenKlinik.getRandevular()[i].getKlinik().getAd()
                                    );
                                    randevusuVardir = true;
                                }
                            }
                        }

                        if (randevusuVardir) {
                            System.out.print("\nSeçmek için Randevu ID girin:");
                            randevuId = scanner.nextInt();
                            for (int i = 0; i < secilenKlinik.getRandevular().length; i++) {
                                if (secilenKlinik.getRandevular()[i] != null && secilenKlinik.getRandevular()[i].getId() == randevuId) {
                                    if (tarihKarsilastir(secilenKlinik.getRandevular()[i].getTarih(), gecerliTarih, true) == 1) {
                                        secilenKlinik.getRandevular()[i].setDurum("iptaledildi");
                                        System.out.println(secilenKlinik.getRandevular()[i].getTarih() + " tarihindeki randevu başarıyla iptal edildi!");
                                    } else {
                                        System.out.println("Randevuyu artık iptal edemezsiniz");
                                    }
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Hastanın Planlanmış Randevusu Yok");
                        }
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    System.out.print("\nAd karakterle başlar (herhangi bir karakter için '*' girin):");
                    char baslaKarakter = scanner.next().charAt(0);
                    System.out.print("\nAd aşağıdaki dizeyi içerir:");
                    String icerirDizeyi = scanner.next();
                    System.out.print("\nAd karakterle başlar (herhangi bir karakter için '*' girin):");
                    char biterKarakter = scanner.next().charAt(0);

                    String[] bulunmusHastalar = hastaArama(secilenHastane, baslaKarakter, icerirDizeyi, biterKarakter);

                    for (int i = 0; i < bulunmusHastalar.length; i++)
                    {
                        if(bulunmusHastalar[i] == null) break;
                        hastaAyrintilariniYazdir(bulunmusHastalar[i]);
                    }

                    break;
                }
                case 7: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSilmek için Klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);
                        if (secilenKlinik.getRandevular("gelecek").length > 0) {
                            System.out.println("Klinik bazı randevular olduğu için kaldırılamıyor.");
                        } else {
                            for (int i = 0; i < secilenHastane.getKlinikler().length; i++) {
                                if (secilenHastane.getKlinikler()[i] == secilenKlinik) {
                                    secilenHastane.klinikSil(secilenKlinik);
                                }
                            }
                        }
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 8: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSeçmek için Klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);

                        secilenKlinik.doktorlarListeleme();
                        System.out.print("\nSilmek için Doctor ID girin:");
                        doctorId = scanner.nextInt();
                        Doktor selectedDoktor = secilenKlinik.getDoktor(doctorId);

                        Randevu[] doktorRandevu = secilenKlinik.getRandevular(selectedDoktor);

                        if (doktorRandevu.length < 1) {
                            secilenKlinik.doktorSil(selectedDoktor);
                        } else {
                            boolean alternativeDoktorBulundu = false;
                            boolean gelecekRandevuVar = false;

                            int randevuIndex = 0;
                            Randevu[] eskiRandevular = new Randevu[secilenKlinik.getRandevular().length];
                            Randevu[] gelecekRandevular = new Randevu[secilenKlinik.getRandevular().length];

                            for (int i = 0; i < doktorRandevu.length; i++) {
                                if (doktorRandevu[i].getDurum().equals("gelecek")) {
                                    gelecekRandevuVar = true;
                                    Randevu dRandevu = doktorRandevu[i];

                                    Doktor alternatifDoktor = null;

                                    for (int k = 0; k < secilenKlinik.getRandevular().length; k++) {
                                        if(tarihKarsilastir(dRandevu.getTarih(), secilenKlinik.getRandevular()[k].getTarih() , true) == 0 &&
                                            !dRandevu.getDoktor().equals(secilenKlinik.getRandevular()[k].getDoktor())
                                        ) continue;

                                        alternatifDoktor = secilenKlinik.getRandevular()[k].getDoktor();
                                        break;
                                    }

                                    if(alternatifDoktor != null){
                                        dRandevu.setDoktor(alternatifDoktor);
                                        alternativeDoktorBulundu = true;
                                    }

                                    gelecekRandevular[i] = dRandevu;
                                } else {
                                    eskiRandevular[randevuIndex] = doktorRandevu[i];
                                    secilenKlinik.randevuSil(doktorRandevu[i]);
                                    randevuIndex++;
                                }
                            }

                            if(alternativeDoktorBulundu || (!gelecekRandevuVar && eskiRandevular.length > 0)){
                                secilenKlinik.randevularGeuncelle(gelecekRandevular);
                                secilenKlinik.doktorSil(selectedDoktor);
                                secilenKlinik.eskiRandevularEkle(eskiRandevular);
                                System.out.println("Silme işlemi başarıyla tamamlandı");
                            }else {
                                System.out.println("Silme islemi yapilmaz");
                            }
                        }
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 9: {
                    int enYueksekRandevuSayisi = 0;

                    for (int i = 0; i < hastaneler.length; i++) {
                        if (hastaneler[i] == null) break;
                        for (int j = 0; j < hastaneler[i].getKlinikler().length; j++) {
                            if (hastaneler[i].getKlinikler()[j] == null) break;
                            Klinik klinik = hastaneler[i].getKlinikler()[j];
                            for (int k = 0; k < klinik.getDoktorlar().length; k++) {
                                if (klinik.getDoktorlar()[k] == null) break;
                                int randevuSayisi = hastaneler[i].getDoktorRandevularSayisi(klinik.getDoktorlar()[k].getAd());
                                if (randevuSayisi > enYueksekRandevuSayisi) {
                                    enYueksekRandevuSayisi = randevuSayisi;
                                    doctorAdi = klinik.getDoktorlar()[k].getAd();
                                }
                            }
                        }
                    }
                    doktorAyrintilariniYazdir(doctorAdi);
                    break;
                }
                case 10: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSeçmek için klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);
                        int enYuksekRandevuSayisi = 0;
                        for (int k = 0; k < secilenKlinik.getHastalar().length; k++) {
                            if (secilenKlinik.getHastalar()[k] == null) break;
                            int randevuSayisi = secilenKlinik.getHastaRadevularSayisi(secilenKlinik.getHastalar()[k].getAd());
                            if (randevuSayisi > enYuksekRandevuSayisi) {
                                enYuksekRandevuSayisi =randevuSayisi;
                                hastaAdi = secilenKlinik.getHastalar()[k].getAd();
                            }
                        }
                        hastaAyrintilariniYazdir(hastaAdi);
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 11: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    System.out.println(secilenHastane.getAd() + "hastanesinde:");
                    for (int i = 0; i < secilenHastane.getKlinikler().length; i++) {
                        if (secilenHastane.getKlinikler()[i] == null) break;
                        secilenHastane.getKlinikler()[i].istatistikleriYazdir();
                    }
                    break;
                }
                case 12: {
                    //print Patient Info
                    System.out.println("Lütfen zaman aralığını girin");
                    System.out.print("\nBaşlangıç tarihini \"(YYYY-AA-GG) biçiminde\" girin");
                    scanner.nextLine();
                    String startDate = scanner.nextLine();
                    System.out.print("\nBitiş tarihini \"(YYYY-AA-GG) biçiminde girin\"");
                    String endDate = scanner.nextLine();

                    randevuAyrintilariniYazdir(startDate, endDate, "tamamlanmis");
                    break;
                }
                case 13: {
                    //print Patient Info
                    System.out.println("Lütfen zaman aralığını girin");
                    System.out.print("\nBaşlangıç tarihini \"(YYYY-AA-GG) biçiminde\" girin");
                    scanner.nextLine();
                    String startDate = scanner.nextLine();
                    System.out.print("\nBitiş tarihini \"(YYYY-AA-GG) biçiminde girin\"");
                    String endDate = scanner.nextLine();

                    //durum: "iptaledildi", "gelecek"
                    randevuAyrintilariniYazdir(startDate, endDate, null);
                    break;
                }
                case 14: {
                    hatanelarListeleme();
                    System.out.print("\nSeçmek için Hastane ID girin:");
                    hastaneId = scanner.nextInt();
                    secilenHastane = getHastane(hastaneId);

                    secilenHastane.klinikleriListeleme();
                    System.out.print("\nSilmek için Klinik ID girin:");
                    klinikId = scanner.nextInt();
                    try
                    {
                        secilenKlinik = secilenHastane.getKlinikler(klinikId);

                        Randevu yenitRandevu = new Randevu();

                        yenitRandevu.setKlinik(secilenKlinik);

                        secilenKlinik.doktorlarListeleme();
                        System.out.print("\nDoktor Seç:");
                        doctorId = scanner.nextInt();
                        secilenDoktor = secilenKlinik.getDoktor(doctorId);

                        yenitRandevu.setDoktor(secilenDoktor);


                        secilenKlinik.hastalarListeleme();
                        System.out.print("\nHasta Seç:");
                        hastaId = scanner.nextInt();
                        secilenHasta = secilenKlinik.getHasta(hastaId);

                        yenitRandevu.setHasta(secilenHasta);

                        System.out.print("\nTarih giriniz:");
                        scanner.nextLine();
                        String yeniTarih = scanner.nextLine();

                        yenitRandevu.setTarih(yeniTarih);
                        yenitRandevu.setDurum("gelecek");

                        secilenKlinik.randevuEkle(yenitRandevu);
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        }
    }

    public static void menuYazdir() {
        System.out.println("Çıkmak için 0 giriniz");
        System.out.println("1. Check if an appointment is available");
        System.out.println("2. Print Hospital infos");
        System.out.println("3. Print the patient with the highest number of appointments");
        System.out.println("4. Print Patient infos");
        System.out.println("5. Cancel Appointment");
        System.out.println("6. Advance Patient search");
        System.out.println("7. Delete a Clinic");
        System.out.println("8. Delete a Doctor");
        System.out.println("9. Show Doctor Infos who has highest number of appointments");
        System.out.println("10.Print the patient infos who has the highest number of appointments from a specific clinic");
        System.out.println("11.Print clinics statistics");
        System.out.println("12.Print all appointments in a specific time range");
        System.out.println("13.Print appointment by status in a specific time range");
        System.out.println("14.Randevu Ekle");
    }

    public static int getRandomInt(int min, int max) {
        return (int) ((Math.random() * ((max + 1) - min)) + min);
    }

    public static Hastane getHastane(int hospitalId) {
        for (int i = 0; i < hastaneler.length; i++) {
            if (hastaneler[i] != null && hastaneler[i].getId() == hospitalId) {
                return hastaneler[i];
            }
        }
        return null;
    }

    public static void hatanelarListeleme() {
        for (int i = 0; i < hastaneler.length; i++) {
            if (hastaneler[i] == null) break;
            System.out.println("ID: " + hastaneler[i].getId() + " - Ad: " + hastaneler[i].getAd());
        }
    }

    public static void HastaneAyrintilariniYazdir(Hastane selectedHastane) {
        System.out.println("**************** Klinikler Bilgiler ****************");
        for (int i = 0; i < selectedHastane.getKlinikler().length; i++) {
            Klinik klinik = selectedHastane.getKlinikler()[i];
            if (klinik == null) break;
            System.out.println("ID: " + klinik.getId());
            System.out.println("Ad: " + klinik.getAd());

            System.out.println("------ Bu Klinikteki Doktorlar -------");
            klinik.doktorlarListeleme();

            System.out.println("------ Randevular -------");
            klinik.randevularYazdir("tumu");
            System.out.println("------ Eski Randevular -------");
            klinik.eskiRandevularListeleme();
            System.out.println("********************************************");
        }
    }

    public static void randevuAyrintilariniYazdir(String startDate, String endDate, String status) {
        for (int i = 0; i < hastaneler.length; i++) {
            if (hastaneler[i] == null) break;
            System.out.println("------ Hastane Bilgileri ------");
            System.out.println("ID: " + hastaneler[i].getId());
            System.out.println("Ad: " + hastaneler[i].getAd());
            Klinik[] kliniks = hastaneler[i].getKlinikler();
            for (int j = 0; j < kliniks.length; j++) {
                Randevu[] randevular = kliniks[j].getRandevular(status);
                System.out.println("------  Klinikler Bilgiler ------");
                System.out.println("ID: " + kliniks[j].getId());
                System.out.println("Ad: " + kliniks[j].getAd());
                if (randevular.length > 0) {
                    System.out.println("------ Randevular -------");
                    for (int k = 0; k < randevular.length; k++) {
                        if (randevular[k] == null) break;
                        if (tarihKarsilastir(tarihToString(tarihSplit(randevular[k].getTarih()),false) , startDate, false) >= 0 &&
                            tarihKarsilastir(tarihToString(tarihSplit(randevular[k].getTarih()),false), endDate, false) <= 0) {
                            System.out.println(
                                    "ID: " + randevular[k].getId()
                                    + " - tarih: " + randevular[k].getTarih()
                                    + " - Durum: " + randevular[k].getDurum()
                                    + " - Doktor: " + randevular[k].getDoktor().getAd()
                                    + " - Hasta: " + randevular[k].getHasta().getAd()
                            );
                        }
                    }
                }
            }
        }
    }

    public static void hastaAyrintilariniYazdir(String hastaName) {
        boolean hastaBilgileriYazilidi = false;
        for (int i = 0; i < hastaneler.length; i++) {
            if (hastaneler[i] == null) break;
            for (int j = 0; j < hastaneler[i].getKlinikler().length; j++) {
                if (hastaneler[i].getKlinikler()[j] == null) break;
                for (int k = 0; k < hastaneler[i].getKlinikler()[j].getRandevular().length; k++) {
                    if (hastaneler[i].getKlinikler()[j].getRandevular()[k] == null) break;
                    if (hastaneler[i].getKlinikler()[j].getRandevular()[k].getHasta().getAd().equals(hastaName)) {
                        if (!hastaBilgileriYazilidi) {
                            System.out.println("+++++++++++++ Hasta Bilgileri ++++++++++++++++");
                            System.out.println("ID: " + hastaneler[i].getKlinikler()[j].getRandevular()[k].getHasta().getId());
                            System.out.println("Ad: " + hastaneler[i].getKlinikler()[j].getRandevular()[k].getHasta().getAd());
                            System.out.println("----- Randevuları -----");
                            hastaBilgileriYazilidi = true;
                        }
                        Randevu appointment = hastaneler[i].getKlinikler()[j].getRandevular()[k];
                        System.out.println("ID: " + appointment.getId());
                        System.out.println("tarih: " + appointment.getTarih());
                        System.out.println("Durum: " + appointment.getDurum());
                        System.out.println("Doktor: " + appointment.getDoktor().getAd());
                        System.out.println("klinik: " + appointment.getKlinik().getAd());
                        System.out.println("----");
                    }
                }
            }
        }
        if(!hastaBilgileriYazilidi){
            System.out.println("Gerilen hastanin adi bulunmadi");
        }
    }

    public static void hastaAyrintilariniYazdir(Hastane hastane, String patientName) {
        boolean hastaBilgileriYazilidi = false;
        for (int j = 0; j < hastane.getKlinikler().length; j++) {
            if (hastane.getKlinikler()[j] == null) break;
            for (int k = 0; k < hastane.getKlinikler()[j].getRandevular().length; k++) {
                if (hastane.getKlinikler()[j].getRandevular()[k] == null) break;
                if (hastane.getKlinikler()[j].getRandevular()[k].getHasta().getAd().equals(patientName)) {
                    if (!hastaBilgileriYazilidi) {
                        System.out.println("+++++++++++++ Hasta Bilgileri ++++++++++++++++");
                        System.out.println("ID: " + hastane.getKlinikler()[j].getRandevular()[k].getHasta().getId());
                        System.out.println("Ad: " + hastane.getKlinikler()[j].getRandevular()[k].getHasta().getAd());
                        System.out.println("----- Randevuları -----");
                        hastaBilgileriYazilidi = true;
                    }
                    Randevu appointment = hastane.getKlinikler()[j].getRandevular()[k];
                    System.out.println("ID: " + appointment.getId());
                    System.out.println("tarih: " + appointment.getTarih());
                    System.out.println("Durum: " + appointment.getDurum());
                    System.out.println("Doktor: " + appointment.getDoktor().getAd());
                    System.out.println("klinik: " + appointment.getKlinik().getAd());
                    System.out.println("----");
                }
            }
        }
        if(!hastaBilgileriYazilidi){
            System.out.println("Gerilen hastanin adi bulunmadi");
        }
    }

    public static void doktorAyrintilariniYazdir(String doctorName) {
        boolean doktorBilgileriYazilidi = false;
        for (int i = 0; i < hastaneler.length; i++) {
            if (hastaneler[i] == null) break;
            for (int j = 0; j < hastaneler[i].getKlinikler().length; j++) {
                if (hastaneler[i].getKlinikler()[j] == null) break;
                for (int k = 0; k < hastaneler[i].getKlinikler()[j].getRandevular().length; k++) {
                    if (hastaneler[i].getKlinikler()[j].getRandevular()[k] == null) break;
                    if (hastaneler[i].getKlinikler()[j].getRandevular()[k].getDoktor().getAd().equals(doctorName)) {
                        if (!doktorBilgileriYazilidi) {
                            System.out.println("+++++++++++++ Doctor Infos ++++++++++++++++");
                            System.out.println("ID: " + hastaneler[i].getKlinikler()[j].getRandevular()[k].getDoktor().getId());
                            System.out.println("Ad: " + hastaneler[i].getKlinikler()[j].getRandevular()[k].getDoktor().getAd());
                            System.out.println("----- Randevuları -----");
                            doktorBilgileriYazilidi = true;
                        }
                        Randevu appointment = hastaneler[i].getKlinikler()[j].getRandevular()[k];
                        System.out.println("ID: " + appointment.getId());
                        System.out.println("tarih: " + appointment.getTarih());
                        System.out.println("Durum: " + appointment.getDurum());
                        System.out.println("Doktor: " + appointment.getDoktor().getAd());
                        System.out.println("klinik: " + appointment.getKlinik().getAd());
                        System.out.println("----");
                    }
                }
            }
        }
    }

    public static String[] hastaArama(Hastane hastane, char startWith, String includes, char endsWith) {
        String[] bulunanHastalar = new String[100];
        int index = 0;
        for (int j = 0; j < hastane.getKlinikler().length; j++) {
            if (hastane.getKlinikler()[j] == null) break;
            for (int k = 0; k < hastane.getKlinikler()[j].getHastalar().length; k++) {
                if (hastane.getKlinikler()[j].getHastalar()[k] == null) break;
                String hastaAd = hastane.getKlinikler()[j].getHastalar()[k].getAd();
                if (
                    (kucukHarfCevier(hastaAd.charAt(0)) == kucukHarfCevier(startWith) || startWith == '*') &&
                    dizeIcerir(diziKucukHarfCevier(hastaAd), diziKucukHarfCevier(includes)) &&
                    (kucukHarfCevier(hastaAd.charAt(hastaAd.length() - 1)) == kucukHarfCevier(endsWith) || endsWith == '*')
                ) {
                    bulunanHastalar[index] = hastaAd;
                    index++;
                }
            }
        }
        return bulunanHastalar;
    }

    private static char kucukHarfCevier(char karakter) {
        int asciiDeger = (int) karakter;

        if(asciiDeger >= 65 && asciiDeger <= 90){
            return (char) (asciiDeger + 32);
        }else {
            return karakter;
        }
    }

    private static String diziKucukHarfCevier(String karakter) {
        String sonuc = "";

        for (int i = 0; i < karakter.length(); i++)
        {
            sonuc += kucukHarfCevier(karakter.charAt(i));
        }
        return sonuc;
    }

    public static boolean dizeIcerir(String selected, String tobeSearch) {
        boolean results = false;
        for (int i = 0; i < selected.length(); i++) {
            if (selected.charAt(i) == tobeSearch.charAt(0) && tobeSearch.length() <= (selected.length() - i)) {
                for (int j = 0; j < tobeSearch.length(); j++) {
                    if (tobeSearch.charAt(j) != selected.charAt(j + i)) {
                        return false;
                    } else {
                        results = true;
                    }
                }
            }
        }
        return results;
    }

    public static Hastane TestVerileriniYukle(String gecerliTarih, int id, String ad) {
        // Load test data
        Hastane hastane = new Hastane(id, 5);

        hastane.setAd(ad);
        String[] klinikNames = {"ophthalmology", "orthopedics", "pediatrics", "general", "endocrinology"};
        String[][] doktorNames = {
                {"Fadil Saker", "adib Aldaikh", "Nour Mhanna", "Wael kfury"},
                {"Kazim Alsaher", "Hatem Aliraqi", "Husam Alrassam", "Mulhem Zain"},
                {"Jorg Wassouf", "Sabah fakhri", "Hani Shaker", "Hani Shaker"},
                {"Shadi Jamil", "Nasif Zaion", "Raghib alama", "Tamer Housni"},
                {"Mustafa Qamar", "Mohammed Munir", "Abdulhalim Hafiz", "Asi Hillani"}
        };
        String[][] hastaNames = {
                {"Jamal Sulaiman", "Abed Fahd", "Samer Almasri"},
                {"Salum Hadad", "Ayman Zedan", "Yaser Alasme"},
                {"Ayman reda", "Qusay Khouly", "Maksim Khalil"},
                {"Basma Yakhour", "Milad Yousif", "Bassam Kosa"},
                {"Taim Hassan", "Jihad Abdo", "Hatim Ali"}
        };

        //  add 5 clinics
        for (int i = 0; i < 5; i++) {
            Klinik klinik = new Klinik(4, 20, 30);
            klinik.setId(i + 1);
            klinik.setAd(klinikNames[i]);

            //  add 4 doctors to each Clinics
            for (int j = 0; j < 4; j++) {
                Doktor doktor = new Doktor();
                doktor.setId(j + 1);
                doktor.setAd(doktorNames[i][j]);
                klinik.doktorEkle(doktor);
            }

            //  add 10 patients
            for (int k = 0; k < 3; k++) {
                Hasta hasta = new Hasta();
                hasta.setId(i + 1);
                hasta.setAd(hastaNames[i][k]);
                klinik.hastaEkle(hasta);
            }

            hastane.getKlinikler()[i] = klinik;
        }

        for (int i = 0; i < 30; i++) {
            Randevu randevu = new Randevu();
            randevu.setId(i + 1);
            String[] status = {"tamamlanmis", "iptaledildi", "gelecek"};
            randevu.setTarih(getRastgeleTarih());
            if(tarihKarsilastir(gecerliTarih, randevu.getTarih(),true) < 0){
                randevu.setDurum(status[getRandomInt(1, 2)]);
            }else {
                randevu.setDurum(status[getRandomInt(0, 1)]);
            }
            Klinik klinik = hastane.getKlinikler()[getRandomInt(0, 4)];
            Doktor doktor = klinik.getDoktorlar()[getRandomInt(0, 3)];
            Hasta hasta = klinik.getHastalar()[getRandomInt(0, 2)];
            randevu.setKlinik(klinik);
            randevu.setDoktor(doktor);
            randevu.setHasta(hasta);
            klinik.randevuEkle(randevu);
        }

        return hastane;
    }

    public static String getRastgeleTarih() {
        return "2022-" + sifiEkle(getRandomInt(1, 12)) + "-" + sifiEkle(getRandomInt(1, 29)) + " saat:" + sifiEkle(getRandomInt(9, 18));
    }

    public static String tarihToString(int[] tarihDizi, boolean saatIle){
        String sonuc = tarihDizi[0] +"-" + sifiEkle(tarihDizi[1]) + "-" + sifiEkle(tarihDizi[2]);

        if(saatIle){
            sonuc += " saat:" + sifiEkle(tarihDizi[3]);
        }
        return sonuc;
    }

    public static int tarihKarsilastir(String fromDate, String toDate, boolean saatIle) {
        int[] tarih = getTarihDizi(fromDate, saatIle);
        int[] karsilastircakTarih = getTarihDizi(toDate, saatIle);

        if (tarih[0] > karsilastircakTarih[0]) {
            return 1;
        } else if (tarih[0] < karsilastircakTarih[0]) {
            return -1;
        } else {
            if (tarih[1] > karsilastircakTarih[1]) {
                return 1;
            } else if (tarih[1] < karsilastircakTarih[1]) {
                return -1;
            } else {
                if (tarih[2] > karsilastircakTarih[2]) {
                    return 1;
                } else if (tarih[2] < karsilastircakTarih[2]) {
                    return -1;
                } else {
                    if(saatIle){
                        if (tarih[3] > karsilastircakTarih[3]) {
                            return 1;
                        } else if (tarih[3] < karsilastircakTarih[3]) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }else {
                        return 0;
                    }

                }
            }
        }
    }

    public static String sifiEkle(int num) {
        return num < 10 ? "0" + num : num + "";
    }

    public static int[] getTarihDizi(String tarih, boolean saatIle){
        int[] tarihDizi = tarihSplit(tarih);
        if(saatIle){
            int saat = saatSplit(tarih);
            return new int[]{tarihDizi[0], tarihDizi[1], tarihDizi[2], saat};
        }else {
            return new int[]{tarihDizi[0], tarihDizi[1], tarihDizi[2]};
        }
    }

    public static int[] tarihSplit(String tarih) {
        int[] spited = new int[3];
        String[] spitedString = {"", "", ""};

        int index = 0;
        for (int i = 0; i < tarih.length(); i++) {
            if (tarih.charAt(i) == ' ') break;
            if (tarih.charAt(i) == '-') {
                index++;
            } else {
                spitedString[index] += tarih.charAt(i);
            }
        }

        for (int i = 0; i < spited.length; i++) {
            spited[i] = Integer.parseInt(spitedString[i]);
        }
        return spited;
    }

    public static int saatSplit(String tarih) {
        String sunuc = "";
        boolean bulundu = false;
        for (int i = 0; i < tarih.length(); i++) {
            if(bulundu){
                sunuc += tarih.charAt(i);
            }
            if (tarih.charAt(i) == ':')  bulundu = true;
        }
        return Integer.parseInt(sunuc);
    }

}
