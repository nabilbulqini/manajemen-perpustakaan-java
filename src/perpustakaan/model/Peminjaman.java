/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */

// class peminjaman
public class Peminjaman {

    // atribut
    private String idPinjam;
    private String idAnggota;
    private String kodeBuku;
    private String tanggalPinjam;
    private StatusPinjam status;

    // constructor
    public Peminjaman(String idPinjam, String idAnggota, String kodeBuku,
                      String tanggalPinjam, StatusPinjam status) {
        this.idPinjam = idPinjam;
        this.idAnggota = idAnggota;
        this.kodeBuku = kodeBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.status = status;
    }

    // getter
    public String getIdPinjam() { 
        return idPinjam; 
    }
    public String getIdAnggota() { 
        return idAnggota; 
    }
    public String getKodeBuku() { 
        return kodeBuku; 
    }
    public String getTanggalPinjam() { 
        return tanggalPinjam; 
    }
    public StatusPinjam getStatus() { 
        return status; 
    }

    // setter 
    public void setStatus(StatusPinjam status) {
        this.status = status;
    }

    // file handling
    public String toDataString() {
        return idPinjam + ";" + idAnggota + ";" + kodeBuku + ";" +
               tanggalPinjam + ";" + status;
    }

    // baca dari file
     public static Peminjaman fromDataString(String line) {
     try {
        String[] d = line.split(";");

        return new Peminjaman(
            d[0], // id pinjam
            d[1], // id anggota
            d[2], // kode buku
            d[3], // tanggal pinjam
            StatusPinjam.valueOf(d[4])
        );

    } catch (Exception e) {
        System.out.println("GAGAL BACA: " + line);
        return null;
    }
}


}
