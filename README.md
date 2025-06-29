# Publisher Service

## Deskripsi (opsional)

Publisher Service adalah layanan backend yang mengelola siklus hidup proses penerbitan konten, termasuk pembuatan, persetujuan, penjadwalan, dan distribusi ke platform atau klien target. Layanan ini memastikan alur kerja yang lancar dan pengiriman konten tepat waktu.

## Fitur

- Pembuatan dan pengeditan konten
- Manajemen alur persetujuan
- Penjadwalan tugas penerbitan
- Distribusi ke berbagai platform target
- Integrasi dengan sistem eksternal
- Logging dan penanganan error

## Teknologi

- Java 17
- Spring Boot 3.x
- JPA / Hibernate
- Maven
- (Opsional) Message broker seperti Kafka atau RabbitMQ

## Prasyarat

- Java 17 sudah terinstall dan terkonfigurasi
- Database (PostgreSQL/MySQL) siap digunakan
- Maven sudah terinstall
- (Opsional) Message broker jika digunakan

## Konfigurasi

Sesuaikan file `application.properties` atau `application.yml` di `src/main/resources`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/namadb
spring.datasource.username=userdb
spring.datasource.password=passworddb
```

Tambahkan konfigurasi message broker jika dipakai.

## Cara Menjalankan
Build project:
```
mvn clean package
```
Jalankan aplikasi:
```
java -jar target/publisher-service-0.0.1-SNAPSHOT.jar
Akses API di: http://localhost:8080/
```
## Contoh Endpoint API
```
POST /api/v1/publish
```
Request body:
```
{
  "contentId": "12345",
  "publishDate": "2025-07-01T10:00:00Z"
}
```
Response:

```{
  "status": "scheduled",
  "contentId": "12345",
  "scheduledAt": "2025-07-01T10:00:00Z"
}
```
Menjalankan Test
Jalankan unit test dengan:
```
mvn test
```
## Kontribusi
Kontribusi sangat kami hargai!
Silakan buat branch baru dan kirim pull request dengan penjelasan perubahan yang jelas.

## Lisensi
Project ini menggunakan lisensi MIT.
Lihat file LICENSE untuk detail.
