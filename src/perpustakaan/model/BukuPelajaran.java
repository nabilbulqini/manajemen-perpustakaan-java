/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */
public class BukuPelajaran extends ItemPerpustakaan {

    private final JenisBuku jenis;
    private StatusBuku status;

    public BukuPelajaran(String kode, String judul, String penulis, int tahun,
                JenisBuku jenis, StatusBuku status) {
 
        super(kode, judul, penulis, tahun);
        this.jenis = jenis;
        this.status = status;
    }

    public JenisBuku getJenis() { 
        return jenis; 
    }
    public StatusBuku getStatus() { 
        return status; 
    }
    
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
        return "Buku";
    }

    // buat simpan ke file
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

    public void setJenisBuku(JenisBuku jenisBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setStatusBuku(StatusBuku statusBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
