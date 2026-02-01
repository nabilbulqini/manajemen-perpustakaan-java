/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */

// Subclass dari abstract class ItemPerpustakaan
public class BukuPelajaran extends ItemPerpustakaan {

    //Atribut khusus
    private final JenisBuku jenis;
    private StatusBuku status;

    // constructor
    public BukuPelajaran(String kode, String judul, String penulis, int tahun,
                JenisBuku jenis, StatusBuku status) {
 
        // pangil atribut dari class itemprppustakaan
        super(kode, judul, penulis, tahun);
        this.jenis = jenis;
        this.status = status;
    }

    //getter dan setter
    public JenisBuku getJenis() { 
        return jenis; 
    }
    public StatusBuku getStatus() { 
        return status; 
    }
    
    // Polymorphism
    public void setStatus(StatusBuku status) { this.status = status; }
    @Override
    public void setJudul(String judul) {
    this.judul = judul;
}

    @Override
    public void setPenulis(String penulis) {
    this.penulis = penulis;
}

    @Override
    public void setTahun(int tahun) {
    this.tahun = tahun;
}


    @Override
    public String getJenisItem() {
        return "PELAJARAN";
    }

    // file handling
    public String toDataString() {
        return kode + ";" + judul + ";" + penulis + ";" + tahun + ";" + jenis + ";" + status;
    }

    // baca dari file
    public static BukuPelajaran fromDataString(String line) {
        String[] data = line.split(";");
        return new BukuPelajaran (
            data[0],
            data[1],
            data[2],
            Integer.parseInt(data[3]),
            JenisBuku.valueOf(data[4]),
            StatusBuku.valueOf(data[5])
        );
    }
    
    
}

