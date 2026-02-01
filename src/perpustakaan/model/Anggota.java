/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */

// class Independen
public class Anggota {

    //Atribut
    private String idAnggota;
    private String nama;
    private String alamat;
    private String noTelp;

    // constructor
    public Anggota(String idAnggota, String nama, String alamat, String noTelp) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    // getter dan setter
    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    // untuk simpan ke file
    public String toDataString() {
        return idAnggota + ";" + nama + ";" + alamat + ";" + noTelp;
    }

    // baca dari file
    public static Anggota fromDataString(String line) {
        String[] data = line.split(";");
        return new Anggota(
            data[0],
            data[1],
            data[2],
            data[3]
        );
    }
}

