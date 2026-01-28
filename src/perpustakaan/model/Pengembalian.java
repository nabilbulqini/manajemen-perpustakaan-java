/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */

import java.time.LocalDate;

public class Pengembalian {

    private String kodeBuku;
    private String namaAnggota;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private int denda;

    public Pengembalian(String kodeBuku, String namaAnggota,
                        LocalDate tanggalPinjam, LocalDate tanggalKembali,
                        int denda) {
        this.kodeBuku = kodeBuku;
        this.namaAnggota = namaAnggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.denda = denda;
    }

    public String getKodeBuku() { return kodeBuku; }
    public String getNamaAnggota() { return namaAnggota; }
    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public LocalDate getTanggalKembali() { return tanggalKembali; }
    public int getDenda() { return denda; }
}
