/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */
public class Majalah extends ItemPerpustakaan {
    private String penulis;      
    private int tahunTerbit;
    
    public Majalah(String kode, String judul, String penulis, int tahun) {
    super(kode, judul, penulis, tahun);
    
    this.penulis = penulis;
    this.tahunTerbit = tahunTerbit;
    }

    // getter & setter
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // POLYMORPHISM 
    @Override
    public String getJenisItem() {
        return "Majalah";
    }
}
