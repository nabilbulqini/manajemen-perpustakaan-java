/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */

// abstract class
public abstract class ItemPerpustakaan {
    //atribut 
    protected String kode;
    protected String judul;
    protected String penulis;
    protected int tahun;

    // constructor
    public ItemPerpustakaan (String kode, String judul, String penulis, int tahun) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    // getter
    public String getKode() { 
        return kode; 
    }
    public String getJudul() { 
        return judul; 
    }
    public String getPenulis() { 
        return penulis; 
    }
    public int getTahun() { 
        return tahun; 
    }
    
    // setter
    public void setJudul(String judul) {
    this.judul = judul;
    }

    public void setPenulis(String penulis) {
    this.penulis = penulis;
    }

    public void setTahun(int tahun) {
    this.tahun = tahun;
    }

    // method abstract membedakan jenis item
    public abstract String getJenisItem();
}
