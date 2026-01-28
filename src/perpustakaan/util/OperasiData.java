/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package perpustakaan.util;

import java.util.List;
import perpustakaan.model.Anggota;
import perpustakaan.model.Buku;
import perpustakaan.model.Peminjaman;

/**
 *
 * @author LENOVO
 */
public interface OperasiData {
   
    // ========== BUKU ==========
    void simpan(Buku b);

    List<Buku> bacaSemua();

    void hapusBuku(String kodeBuku);

    List<Buku> cariBuku(String keyword);
    
    // ========== ANGGOTA ==========
    void simpanAnggota(Anggota a);

    List<Anggota> bacaSemuaAnggota();

    void hapusAnggota(String id);

    List<Anggota> cariAnggota(String keyword);
    
    // ========== PEMINJAMAN ==========
    void simpanPeminjaman(Peminjaman p);

    List<Peminjaman> bacaSemuaPeminjaman();

    void hapusPeminjaman(String idPinjam);

    List<Peminjaman> cariPeminjaman(String keyword);
    
}
