package com.example.penjualan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNamaPelanggan, etNamaBarang, etJumlahBeli, etHarga, etUangBayar;
    private TextView totalBelanjaTextView, uangKembaliTextView, keteranganTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaPelanggan = findViewById(R.id.namapelanggan);
        etNamaBarang = findViewById(R.id.namabarang);
        etJumlahBeli = findViewById(R.id.jumlahbeli);
        etHarga = findViewById(R.id.harga);
        etUangBayar = findViewById(R.id.uangbayar);

        totalBelanjaTextView = findViewById(R.id.totalbelanja);
        uangKembaliTextView = findViewById(R.id.uangkembali);
        keteranganTextView = findViewById(R.id.keterangan);

        Button btnProses = findViewById(R.id.tombol1);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesPenjualan(); // Panggil method prosesPenjualan saat tombol proses diklik
            }
        });
    }

    private void prosesPenjualan() {
        // Ambil nilai dari EditText
        String namaPelanggan = etNamaPelanggan.getText().toString();
        String namaBarang = etNamaBarang.getText().toString();
        int jumlahBeli = Integer.parseInt(etJumlahBeli.getText().toString());
        double harga = Double.parseDouble(etHarga.getText().toString());
        double uangBayar = Double.parseDouble(etUangBayar.getText().toString());

        // Lakukan proses penjualan di sini
        double totalHarga = jumlahBeli * harga;
        double kembalian = uangBayar - totalHarga;

        // Tampilkan hasil proses penjualan
        totalBelanjaTextView.setText("Total Belanja: " + totalHarga);
        uangKembaliTextView.setText("Uang Kembali: " + kembalian);
        if (kembalian >= 0) {
            keteranganTextView.setText("Keterangan: Transaksi Berhasil");
        } else {
            keteranganTextView.setText("Keterangan: Uang Bayar Kurang");
        }
    }
}
