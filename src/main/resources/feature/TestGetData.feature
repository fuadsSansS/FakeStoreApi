Feature: Mengambil Data Pengguna Tunggal

  Scenario: Mendapatkan data pengguna berdasarkan ID
    Given Saya memiliki base URL
    When Saya mengirim permintaan GET ke "products/1"
    Then Kode status respons harus 200
    And Respons harus berisi data pengguna dengan ID 1
    And Respons harus memiliki tipe konten "application/json; charset=utf-8"
    And Validasi Nama Title "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    Then Validasi Rating Rate 3.9
