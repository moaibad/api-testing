
# api-testing

Repository ini bertujuan untuk melakukan pengujian API pada website DummyAPI https://dummyapi.io/. Pengujian ini difokuskan pada objek Pengguna (User) dan mencakup semua metode permintaan HTTP (CREATE, UPDATE/PUT, GET, DELETE).

## Teknologi yang Digunakan

**Programming Languange:** Java 17

**Builder Tools:** Apache Maven

**Testing Tools:** TestNG, Rest Assured

**Test Report Generator:** ExtentReports
## Menjalankan Pengujian


1. Pastikan JDK17+ dan Apache Maven 3.9.4+ sudah terinstall pada komputer.

2. Lakukan clone git repository dengan menjalankan perintah
```bash
  git clone https://github.com/moaibad/api-testing.git
```
3. Masuk ke dalam direktori project dengan menjalankan perintah
```bash
  cd api-testing
```

4. Jalankan perintah berikut untuk menjalankan semua testcase
```bash
  mvn clean test
```

5. Tunggu hingga proses pengujian selesai.
  
6. Jika sudah selesai, maka hasil pengujian dapat dilihat pada terminal seperti gambar berikut.

![image](https://github.com/moaibad/api-testing/assets/95458318/bc86d4d2-95c9-45b5-943b-97a8e0fe6420)

8. Hasil generated test report akan secara otomatis terbuka pada browser, berikut merupakan hasil dari generated test report menggunakan library ExtentReports.

![image](https://github.com/moaibad/api-testing/assets/95458318/c4d7666e-8cdd-4ed8-a57c-ae663ac259e5)

![image](https://github.com/moaibad/api-testing/assets/95458318/6063e66b-33ca-4bdd-8863-f2eab84924e0)

![image](https://github.com/moaibad/api-testing/assets/95458318/1bc42772-29b5-4e38-9669-5135004f5da2)

9. Jika generated test report tidak terbuka secara otomatis pada browser, Anda dapat menemukan report nya dalam format html di direktori `/test-output/api-testing.html`.


## TestNG Suite

Untuk menjalankan pengujian ini, Anda dapat mengkonfigurasi `testng.xml` dengan menggunakan konfigurasi berikut:
```bash
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
    <listeners>
        <listener class-name="ExtentReportListener"/>
    </listeners>
    <test name="Test">
        <classes>
            <class name="TestAPI"/>
            <class name="GETMethodTest"/>
        </classes>
    </test>
</suite>
```

Anda dapat melakukan kostumisasi konfigurasi untuk menentukan class-class mana saja yang akan digenerate dengan menggunakan tag `<class>`.
## Authors
- <img src="https://avatars.githubusercontent.com/u/78577365?v=4" width="20" height="20" alt="Avatar"> [@fikrihidayatulloh16](https://www.github.com/fikrihidayatulloh16) (Muhammad Fikri Hidayatulloh - 201524017)
- <img src="https://avatars.githubusercontent.com/u/95458318?v=4" width="20" height="20" alt="Avatar"> [@moaibad](https://www.github.com/moaibad) (Mohammad Fathul'ibad - 211524015)
- <img src="https://avatars.githubusercontent.com/u/95167399?v=4" width="20" height="20" alt="Avatar"> [@Rekabriyan](https://www.github.com/Rekabriyan) (Reka Briyan Cahya Heryana - 211524024)


## License

[MIT](https://choosealicense.com/licenses/mit/)
