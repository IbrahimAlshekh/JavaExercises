# Hastane Appointments System


Hastane Randevu Sistemi uygulaması için istenen işlemler:

Örnek olarak 5 tane sınıfınız olduğunu düşünebilirsiniz;
Hastane, Randevu, Hasta, Klinik, Doktor (bu sınıflar sadece örnektir,
siz kendi uygulamanıza uygun olarak gerekli programatik tasarımı
yapmalısınız).
1. Adı girilen hastane ve klinik için alınabilecek randevuların
   listelenmesi (hastane, klinik ve ilgili klinikteki doktor bilgileri gibi)
2. Şimdiye kadar alınmış farklı kliniklerden olan randevuların
   listelenmesi
3. En çok randevusu olan hastanın tüm randevu bilgilerinin listelenmesi
   (hasta bilgileri, hastane bilgisi, klinik bilgisi, randevu tarihi vb.
   bilgiler)
4. Adı girilen hastanın geçmişteki ve gelecekteki randevularının
   listelenmesi
5. Hasta, randevu tarihinden en geç 1 gün önce randevusunu iptal
   edebilir. 1 günden daha az bir süre kaldıysa randevu iptal edilemez veya
   değişiklik yapılamaz. 1 günden daha fazla bir süre varsa almış olduğu
   randevuyu güncelleyebilir.
6. Karmaşık String araması yapılabilir. Adı * ile başlayan ve adının
   içerisinde ‘dul’ veya ‘hme’ geçen ve sonu ‘t’ ile biten hastanın ya da
   hastaların randevu bilgisini (geçmişte ve gelecekte bulunan randevular)
   ekrana yazar
   (Not: * herhangi bir harf olabilir, büyük veya küçük farketmez)
7. Klinik silebilme
   • Silinecek klinik için herhangi bir hasta tarafından gelecekte randevu
   alınmamış olması gerekir. Eğer varsa bilgi verilip klinik silme işlemi
   yapılmamalı
   • Silinmek istenen klinikten herhangi bir randevu alınmadıysa
   (gelecekteki randevu) ilgili klinik silinmelidir ve kliniğin bulunduğu
   hastanede bu klinik için bir daha randevu verilmemelidir.
8. Doktor silebilme
   • Silinecek doktorun aktif bir randevusu veya gelecekte ilgili doktora
   alınmış bir randevu yoksa bu doktor silinebilir. Eğer varsa bilgi verilip
   bu aktif randevu veya randevular rastgele olarak başka doktor/doktorların
   üzerine atanmalı. Eğer sistemde doktorun çalıştığı klinik için randevu
   atanabilecek (randevu çakışması yok ise) başka bir doktor yoksa silme
   işlemi yapılmamalı. Eğer randevu atanabilecek başka bir doktor varsa
   silme işlemi yapılmalı ve silinen bu doktora ait daha önceki randevular
   “eskiRandevular” listesine eklenerek saklanmalı
9. Girilen tarihte en fazla hastaya bakan (Randevu sınıfı içerisinde
   randevuDurumu bilgisi tutulmalı) doktorun bilgileri listelenmesi.
10. Klinik bazında en çok randevu alan hastaların bilgilerinin
    listelenmesi.
11. Girilen hastane bazında, her klinik için alınan ortalama, maksimum
    ve minimum randevu sayılarının listelenmesi (X hastanesinde z kliniği
    için maksimum, ortalama, minimum randevusu sayısı şudur, X hastanesinde
    b kliniği için maksimum, ortalama, minimum randevu sayısı şudur şeklinde)

12. Verilen tarihler arasındaki bütün tamamlanmış randevuların
    listelenmesi
13. Verilen tarihler arasındaki bütün tamamlanmamış/gelecekteki
    randevuların listelenmesi. İlgili randevuyu alan müşteri bilgileri,
    klinik bilgisi, doktor bilgisi, hastane bilgisi, randevu tarihi vb.
    bilgiler listelenmeli.