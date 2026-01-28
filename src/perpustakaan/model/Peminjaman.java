/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.model;

/**
 *
 * @author LENOVO
 */
public class Peminjaman {

    private String idPinjam;
    private String kodeBuku;
    private String idAnggota;
    private String tanggalPinjam;
    private String tanggalKembali;
    private StatusPinjam status;

    public Peminjaman(String idPeminjaman, String kodeBuku,String idAnggota, 
                      String tanggalPinjam, String tanggalKembali,
                      StatusPinjam status) {
        this.idPinjam = idPeminjaman;
        this.kodeBuku = kodeBuku;
        this.idAnggota = idAnggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    // GETTER SETTER
    public String getIdPinjam() { 
        return idPinjam;
    }
    
    public String getKodeBuku() { 
        return kodeBuku; 
    }
    
    public String getIdAnggota() { 
        return idAnggota; 
    }
   
    public String getTanggalPinjam() { 
        return tanggalPinjam; 
    }
    public String getTanggalKembali() { 
        return tanggalKembali; 
    }
    
    public StatusPinjam getStatus() { 
        return status; 
    }

    public void setStatus(StatusPinjam status) {
        this.status = status;
    }
}
