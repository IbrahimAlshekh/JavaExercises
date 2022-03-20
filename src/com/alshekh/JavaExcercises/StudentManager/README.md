# Course Manage

Bir üniversitenin bölüm, bölümün öğrencileri ve bölümde açılan derslerin bir kısmını temsil
eden otomasyon aşağıdaki gibidir. Ödevde üniversitede yer alan bölümler, bu bölümlerde
öğrenim gören öğrenciler ve bu bölümlerde açılan ders bilgilerinin yer aldığı bir otomasyon
yapılması istenmektedir. Üniversitede birden fazla bölüm, her bölümde öğrenim gören birden
fazla öğrenci ve her bölümde açılan birden fazla ders bulunmaktadır. Ödev **main** fonksiyonun
olduğu AnaSayfa class’ı dışında aşağıda özellikleri listelenen 3 class’ı içermelidir.


| Bolum                  | Ogrenci           |            Ders |
|:-----------------------|-------------------|----------------:|
| bolNo (int)            | bolNo (int)       |     bolNo (int) |
 | bolAd (String)         | ogrID (int)       |    dersID (int) |
 | ogrenciler[] (Ogrenci) | ogrAd (String)    | dersAd (String) |
 | dersler[] (Ders)       | ogrSoyad (String) | dersKredi (int) |
 |                        | ogrSinif (int)    ||


Yukarıdan belirtilen class’lar **Kapsülleme** (Encapsulation – sınıf özellikleri private olmalı,
Bolum sınıfında yer alan ogrenciler ve dersler dizisini public yapabilirsiniz) özelliklerini
sağlamalıdır. **ogrID**, her öğrenci oluşturulduğunda otomatik olarak artırılıp atanacaktır. **dersID**,
her servis oluşturulduğunda otomatik olarak artırılıp atanacaktır. Class’lar oluşturulduktan
sonra aşağıdaki işlemler sırasıyla yapılmalıdır.

1. Kullanıcıdan kaç tane bölüm olacağı bilgisi istenecektir ve girilen sayı adedince bölüm
   bilgilerini tutacak bir Bolum dizisi oluşturulacaktır.


2. Her bir bölüm bilgileri kullanıcıdan alınarak Bolum dizisi bilgileri
   doldurulacaktır. Bölüm bilgileri alınırken:
   - a. Öncelikle bölüm no ve ad bilgileri alınacaktır. 
   - b. Daha sonra kaydı alınan bölüm için kaç öğrenci olduğu bilgisi sorulacak ve girilen adet kadar öğrenci bilgilerini 
   tutacak olan ogrenciler dizisi boyutlandırılacaktır. Daha sonra gene bir döngü ile bu bölüme ait tüm öğrencilerin 
   bilgileri kullanıcı tarafından girilecektir. Ogrenci sınıfında yer alan bolNo özelliği ait olduğu bölümden alınıp 
   otomatik olarak atanacaktır, kullanıcıdan giriş istenmeyecektir.
   - c. Daha sonra kaydı alınan bölüm için açılan kaç dersinin olduğu bilgisi sorulacak ve
   girilen adet kadar ders bilgilerini tutacak olan dersler dizisi boyutlandırılacaktır. Daha sonra
   gene bir döngü ile bu bölüme ait tüm derslerin bilgileri kullanıcı tarafından girilecektir. Ders
   sınıfında yer alan bolNo özelliği ait olduğu bölümden alınıp otomatik olarak atanacaktır,
   kullanıcıdan giriş istenmeyecektir.

   
3. Bilgi alma işlemi sona erdikten sonra kullanıcıya aşağıda gösterilen şekilde bir menü
   sunulacaktır:


   1. Tüm Bölümlerin Bilgilerini Listele
   2. Bölüm Adına Göre Arama Yap
   3. Öğrenci Adına Göre Arama Yap
   4. Ders Adına Göre Arama Yap
   5. Sınıf Bilgisine Göre Öğrencileri Bul
   6. Ders Kredisine Göre Dersleri Bul
   7. Çıkış
     Menü açıklamaları;


1- **Tüm Bölümlerin Bilgilerini Listele:** seçildiğinde tüm bölümlerin bilgileri ekrana
yazılacaktır. Bir bölüm için örnek yazdırma şekli aşağıdaki gibidir.
Bölüm No: 10 Bölüm Ad: 

Bilgisayar Mühendisliği
 - Öğrenciler:
   1. Öğrenci: 20 Ali Kara 3
   2. Öğrenci: 21 Seda Adacı 1
   3. Öğrenci: 22 Fatma Kılınç 4
   4. Öğrenci: 23 Buğra Kaya 2
   5. Öğrenci: 24 Selim Ak 2
   6. Öğrenci: 25 Firdevs Tutar 1
 - Dersler:
   1. Ders: 10 Algoritma ve Programlama 5
   2. Ders: 11 Matematik 3
   3. Ders: 12 Fizik 3
   4. Ders: 13 Nesne Yönelimli Programlama 5
   5. Ders: 14 Mobil Programlama 4

2. **Bölüm Adına Göre Arama Yap:** seçildiğinde kullanıcıdan aranacak isim istenecek ve
bu isme sahip bölüm bilgileri yukarıdaki (1. seçenekteki) formatta ekrana yazdırılacaktır.
Bölüm bulunamazsa bulunamadı şeklinde mesaj yazdırılacaktır.


3. **Öğrenci Adına Göre Arama Yap:** seçildiğinde kullanıcıdan aranacak isim istenecek ve
bu isme sahip öğrenci/öğrencilerin bilgileri ekrana yazdırılacaktır. Öğrenci bilgileri
yazdırılırken bu öğrencinin hangi bölüme ait olduğu bilgisi de yer almalıdır.
Öğrenci bulunamazsa bulunamadı şeklinde mesaj yazdırılacaktır.


4. **Ders Adına Göre Arama Yap:** seçildiğinde kullanıcıdan aranacak ders adı istenecek ve bu
ders adına sahip ders/derslerin bilgileri ekrana yazdırılacaktır. Ders bilgileri yazdırılırken bu
dersin hangi bölüme ait olduğu bilgisi de yer almalıdır.
Ders bulunamazsa bulunamadı şeklinde mesaj yazdırılacaktır.


5. **Sınıf Bilgisine Göre Öğrencileri Bul:** seçildiğinde kullanıcıdan hangi sınıfa ait öğrencileri
listelenmesi istendiği sorulacak ve kullanıcıdan alınan sınıf bilgisine göre o sınıf olan
öğrencilerin bilgileri ekrana yazdırılacaktır. Öğrenci bilgileri yazdırılırken öğrencinin hangi
bölüme ait olduğu bilgisi de yer almalıdır.


6. **Ders Kredisine Göre Dersleri Bul:** seçildiğinde kullanıcıdan hangi ders kredisine göre
derslerin listelenmesi istendiği sorulacak ve kullanıcıdan alınan kredi bilgisine göre o krediye
sahip olan derslerin bilgileri ekrana yazdırılacaktır. Ders bilgileri yazdırılırken dersin hangi
bölüme ait olduğu bilgisi de yer almalıdır.


7. **Çıkış:** seçildiğinde program sonlanacaktır.


**Not:** Çıkış Yap seçeneği seçilene kadar menü her seçimden sonra tekrar seçim yapılmasını
sağlamak zorundadır.