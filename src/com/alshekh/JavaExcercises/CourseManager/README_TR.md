# Sanat Merkezi Otomasyonu 

Bir sanat merkezinin kursiyerleri ve bu sanat merkezinde yer alan kursların takip
edilebilmesini sağlayan bir otomasyon yapılacaktır. Bu sanat merkezinde birçok branşta kurs
bulunmaktadır. Sanat merkezine kaydolan kursiyer bir veya birden fazla kursa
kaydolabilmektedir. Kursiyer bilgileri, kurs bilgileri ve kursiyerleri kayıt oldukları kursların
bilgileri tutulacaktır. 

Otomasyon **Kursiyer.java, Kurs.java** ve **Anasayfa.java** sınıflarından oluşmaktadır.
Anasayfa.java sınıfında **main** fonksiyonu bulunmaktadır. Kursiyer.java ve Kurs.java
sınıflarının içermesi gereken özellikler aşağıdaki gibidir. Bu iki sınıf **Kapsülleme**
(Encapsulation – sınıf özellikleri private olmalıdır, Kursiyer.java’daki alinanKurslar özelliği
hariç) özelliklerini sağlamalıdır.

#### Kursiyer.java           
- kursiyerId (int)
- kursiyerAdSoyad (String)
- kursiyerYas (int)
- alinanKurslar (List<Kurs>)

#### Kurs.java 
- kursId (int)
- kursAd (String)

Kursiyerlerin bilgileri **kursiyer.txt** dosyasında tutulacaktır. Kurs bilgileri ise **kurs.txt**
dosyasında tutulacaktır. Örnek dosya içerikleri aşağıdaki gibidir: 

#### kursiyer.txt
    *5050-Ahmet Ada-23
    %1000-Resim
    %1040-Hat
    *6085-Selda Şahin-35
    %1020-Çini
    *5090-Deniz Arslan-30
    %1000-Resim
    %1060-Tel kırma
    *6174-Tarık Kılıç-42
    %1010-Ebru
    %1030-Tezhip
    %1050-Seramik
    *7075-Ayşe Kaya-20
    %1070-Müzik
    %1080-Tiyatro
    %1100-Grafik

#### kurs.txt
    1000-Resim
    1010-Ebru
    1020-Çini
    1030-Tezhip
    1040-Hat
    1050-
    Seramik
    1060-Tel
    kırma
    1070-Müzik
    1080-Tiyatro
    1090-Dans
    1100-Grafik 

Yukarıdaki dosya içeriklerinde görüldüğü gibi kursiyer.txt dosyasında satırın ilk karakteri `‘*’`
ile başlıyorsa kursiyerin bilgileri olduğu ve hemen altında `‘%’` karakteri ile başlayan satırlar o
kursiyerin aldığı kursları ifade etmektedir. İki dosyada da her bilgi `‘-’` karakteri ile birbirinden
ayrılmıştır. Dosyadan okuma yapılırken ve dosyalara bilgi yazılırken bu formatlara dikkat
edilmelidir. 

AnaSayfa.java sınıfında işlemler menü kontrolü gerçekleştirilecektir. Menü’ den bitir/çıkış
fonksiyonu seçilene kadar program çalışır durumda olacaktır. Program ilk çalıştırıldığında
kursiyer bilgileri kursiyer.txt dosyasından okunup kursiyerler listesine `(Kursiyerler
ArrayList<Kursiyer>)` eklenecektir. Aynı şekilde kurs.txt dosyasının içindeki kurs bilgileri
kurslar listesine `(Kurslar ArrayList<Kurs>)` eklenecektir. Bilgi alma işlemi sona erdikten
sonra kullanıcıya aşağıdaki gibi bir menü sunulacaktır:

1. Kurs Ekle
2. Kurs Listele
3. Kursiyer Ekle
4. Kursiyer Ara
5. Kursiyer Sil
6. Kursiyerleri Listele
7. Kursiyerleri Ayrıntılı Listele
8. Kursiyerin Ödeyeceği Tutarı Hesapla
9. Çıkış


Anasayfa.java sınıfında yer alacak menünün sağlayacağı metotlar aşağıda listelenmiştir.
Menünün her bir seçeneği bir metot ile yapılacaktır. 

1. **Kurs Ekle();** Yeni kurs bilgileri kullanıcıdan alınacak ve listeye eklenecektir.
   Ekleme yapılırken aynı ID ile başka kayıt olup olmadığı kontrol edilecek.
2. **Kurs Listeleme();** Listedeki tüm kursların bilgileri ekrana aşağıdaki biçimde
   yazılacaktır.

| Kurs Id | Kurs Adı |
|:--------|---------:|
| 1000    |    Resim |
 | 1010    |     Ebru |
 | 1020    |     Çini |
 | 1030    |   Tezhip |
 | 1040    |      Hat |
 | 1050    |  Seramik |
 | 1060    | Telkırma |
 | 1070    |    Müzik |
 | 1080    |  Tiyatro |
 | 1090    |     Dans |
 | 1100    |   Grafik | 

3. **Kursiyer Ekle();** Eklenecek olan kursiyere ait bilgiler (kaydolacağı kurslar da dâhil)
   kullanıcıdan alınacak ve yeni kursiyer, kursiyerler listesine eklenecektir. Ekleme
   yapılırken aynı Id ile başka kayıt olup olmadığı kontrol edilecek.


4. **Kursiyer Arama(kursiyerAdSoyad);** Kursiyer ad-soyadına göre aranacak. Eğer
   kursiyer listede bulunursa bilgileri ekrana yazılacak, bulunamazsa bulunamadı mesajı
   verilecek.


5. **Kursiyer Sil(kursiyerId);** Id’si verilen kursiyer listede bulunursa silinecek,
   bulunamazsa bulunamadı mesajı verilecek.


6. **Kursiyer Listele();** Listedeki tüm kursiyer bilgileri aşağıdaki formatta ekrana
   yazdırılacak.
   + **Tüm Kursiyerler**
   + 5050 Ahmet Ada 23 6085
   + Selda Şahin 35
   + 5090 Deniz Arslan 30 6174
   + Tarık Kılıç 42
   + 7075 Ayşe Kaya 20 
   

7. **Kursiyer Ayrıntılı Listele();** Listedeki tüm kursiyer bilgileri aşağıdaki formatta
   ekrana yazdırılacak.
   
    **Tüm Kursiyerler ve Aldıkları Kurslar**
   - 5050 Ahmet Ada 23
     - 1000 Resim
     - 1040 Hat
   - 6085 Selda Şahin 35
     - 1020 Çini
   - 5090 Deniz Arslan 30
     - 1000 Resim
     - 1060 Tel kırma
   - 6174 Tarık Kılıç 42
     - 1010 Ebru
     - 1030 Tezhip
     - 1050 Seramik
   - 7075 Ayşe Kaya 20
     - 1070 Müzik
     - 1080 Tiyatro
     - 1100 Grafik

8. **Kursiyerin Ödeyeceği Tutar Hesaplama(kursiyerId);** Id’si verilen kursiyerin sanat
   merkezine ödeyeceği aylık toplam ücret hesaplanmalıdır. Her kurs ücreti haftalık 100
   TL’dir. Kurs kampanyaları şu şekildedir.

**- Kampanya 1:** Bu kampanya 2 kurs alan kursiyerler içindir. Bu kursiyerlere  ikinci kurs %15 indirimlidir.

**- Kampanya 2:** Bu kampanya 3 kurs alan kursiyerler içindir. Bu kursiyerlere 3. kurs %25 indirimlidir.
    
**- Kampanya 3:** Bu kampanya 3 kurs üstü alan kursiyerler içindir. Bu kursiyerlere ise her kurs %10 indirimlidir.

Bu bilgilere dayanarak kursiyerin aylık spor merkezine ödeyeceği toplam ücreti
hesaplayınız ve kursiyerin hangi kampanyadan faydalandığı bilgisini veriniz.
Kursiyer tek kurs almışsa tek kurs alana kampanya olmadığı bilgisini de
ekleyiniz. 


9. **Bitir();** Kursiyerler listesindeki kursiyer bilgileri `kursiyer.txt` dosyasına yazılacak,
   kurslar listesindeki kurs bilgileri `kurs.txt` dosyasına yazılacak. Dosyaya yazma işlemi
   yapılacağı zaman, dosyadaki önceki kayıtların silinmesi ve yeni bilgilerin yazılması
   gerekmektedir.
   
   
   