/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.util;

/**
 *
 * @author LENOVO
 */

   import perpustakaan.model.BukuPelajaran;
   import perpustakaan.model.JenisBuku;
   import perpustakaan.model.StatusBuku;
   import perpustakaan.model.Anggota;
   import perpustakaan.model.Peminjaman;
   import perpustakaan.model.StatusPinjam;
   import java.io.*;
   import java.util.*;
   
   

   public class FileManager implements OperasiData {

    // ========== BUKU ==========
    private final String FILE = "buku.txt";

    // Method Simpan Buku pada buku.txt
    @Override
    public void simpan(BukuPelajaran b) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
            bw.write(
                b.getKode() + ";" +
                b.getJudul() + ";" +
                b.getPenulis() + ";" +
                b.getTahun() + ";" +
                b.getJenis() + ";" +
                b.getStatus()
            );
            bw.newLine();
        } catch (IOException e) {
        }
    }

    // Method Baca Buku Pada buku.txt
    
    @Override
    public List<BukuPelajaran> bacaSemua() {
        List<BukuPelajaran> list = new ArrayList<>();

        File file = new File(FILE);
        if (!file.exists()) return list;
        File f = new File("buku.txt");
        System.out.println("PATH FILE: " + f.getAbsolutePath());
        System.out.println("FILE ADA? " + f.exists());


        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                BukuPelajaran b = new BukuPelajaran(
                    data[0],
                    data[1],
                    data[2],
                    Integer.parseInt(data[3]),
                    JenisBuku.valueOf(data[4]),
                    StatusBuku.valueOf(data[5])
                );

                list.add(b);
            }
        } catch (Exception e) {
        System.out.println("GAGAL BACA BARIS: ");
}


        return list;
    }
    
    // Method Hapus Buku dalam buku.txt
    @Override
    public void hapusBuku(String kodeBuku) {
    List<String> hasil = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("buku.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(kodeBuku + ";")) {
                hasil.add(line);
            }
        }
    } catch (IOException e) {
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("buku.txt"))) {
        for (String data : hasil) {
            bw.write(data);
            bw.newLine();
        }
    } catch (IOException e) {
    }
  }
    
    // Method cari buku pada buku.txt
    @Override
    public List<BukuPelajaran> cariBuku(String keyword) {
    List<BukuPelajaran> hasil = new ArrayList<>();

    for (BukuPelajaran b : bacaSemua()) {
        if (b.getJudul().toLowerCase().contains(keyword.toLowerCase())
            || b.getKode().toLowerCase().contains(keyword.toLowerCase())
            || b.getPenulis().toLowerCase().contains(keyword.toLowerCase())) {

            hasil.add(b);
        }
    }
    return hasil;
}
    
    //Method Edit Buku pada buku.txt
    public void updateBuku(BukuPelajaran bukuBaru) {
    List<BukuPelajaran> list = bacaSemua();

    try (BufferedWriter bw =
         new BufferedWriter(new FileWriter("buku.txt"))) {

        for (BukuPelajaran b : list) {
            if (b.getKode().equals(bukuBaru.getKode())) {
                b = bukuBaru;
            }

            bw.write(
                b.getKode() + ";" +
                b.getJudul() + ";" +
                b.getPenulis() + ";" +
                b.getTahun() + ";" +
                b.getJenis() + ";" +
                b.getStatus()
            );
            bw.newLine();
        }

    } catch (IOException e) {
    }
}
    
    // Method Ubah status buku pada buku.txt  
    public void ubahStatusBuku(String kodeBuku, StatusBuku statusBaru) {
        List<BukuPelajaran> list = bacaSemua();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buku.txt"))) {
            for (BukuPelajaran b : list) {

                if (b.getKode().equals(kodeBuku)) {
                    b.setStatus(statusBaru);
                }

                bw.write(
                    b.getKode() + ";" +
                    b.getJudul() + ";" +
                    b.getPenulis() + ";" +
                    b.getTahun() + ";" +
                    b.getJenis() + ";" +
                    b.getStatus()
                );
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }


    // ========== ANGGOTA =========
    private final String FILE_ANGGOTA = "anggota.txt";
    
    // Method simpan anggota pada anggota.txt
    @Override
    public void simpanAnggota(Anggota a) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ANGGOTA, true))) {
        bw.write(a.toDataString());
        bw.newLine();
    } catch (IOException e) {
    }
}

    // Method Baca Semua anggota pada anggota.txt
    @Override
    public List<Anggota> bacaSemuaAnggota() {
    List<Anggota> list = new ArrayList<>();
    File file = new File(FILE_ANGGOTA);
    if (!file.exists()) return list;

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_ANGGOTA))) {
        String line;
        while ((line = br.readLine()) != null) {
            list.add(Anggota.fromDataString(line));
        }
    } catch (IOException e) {
    }
    return list;
}

    // Method Hapus anggota pada anggota.txt
    @Override
    public void hapusAnggota(String id) {
    List<Anggota> list = bacaSemuaAnggota();

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ANGGOTA))) {
        for (Anggota a : list) {
            if (!a.getIdAnggota().equals(id)) {
                bw.write(a.toDataString());
                bw.newLine();
            }
        }
    } catch (IOException e) {
    }
}

    // Method edit anggota pada anggota.txt
    public void updateAnggota(Anggota anggotaBaru) {
    List<Anggota> list = bacaSemuaAnggota();

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ANGGOTA))) {
        for (Anggota a : list) {
            if (a.getIdAnggota().equals(anggotaBaru.getIdAnggota())) {
                a = anggotaBaru;
            }
            bw.write(a.toDataString());
            bw.newLine();
        }
    } catch (IOException e) {
    }
}

    // Method Cari anggota pada anggota.txt
    @Override
    public List<Anggota> cariAnggota(String keyword) {
    List<Anggota> hasil = new ArrayList<>();

    for (Anggota a : bacaSemuaAnggota()) {
        if (a.getNama().toLowerCase().contains(keyword.toLowerCase())
            || a.getIdAnggota().toLowerCase().contains(keyword.toLowerCase())) {
            hasil.add(a);
        }
    }
    return hasil;
}
    
    // =========== PEMINJAMAM ===========
    private final String FILE_PEMINJAMAN = "peminjaman.txt";
    
    // Method Simpan Peminjaman pada peminjaman.txt
    @Override
    public void simpanPeminjaman(Peminjaman p) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PEMINJAMAN, true))) {
        bw.write(
            p.getIdPinjam() + ";" +
            p.getKodeBuku() + ";" +
            p.getIdAnggota() + ";" +
            p.getTanggalPinjam() + ";" +
            p.getStatus()
        );
        bw.newLine();
    } catch (IOException e) {
    }
}
    
    // Method baca semua peminjaman pada peminjaman.txt
    @Override
   public List<Peminjaman> bacaSemuaPeminjaman() {
    List<Peminjaman> list = new ArrayList<>();
    File file = new File(FILE_PEMINJAMAN);
    if (!file.exists()) return list;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {

            Peminjaman p = Peminjaman.fromDataString(line);
            if (p != null) {
                list.add(p);
            }

        }
    } catch (Exception e) {
    }

    return list;
}


    // Method hapus Peminjaman pada peminjaman.txt
    @Override
    public void hapusPeminjaman (String idPinjam) {
    List<String> hasil = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("peminjaman.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(idPinjam + ";")) {
                hasil.add(line);
            }
        }
    } catch (IOException e) {
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("peminjaman.txt"))) {
        for (String data : hasil) {
            bw.write(data);
            bw.newLine();
        }
    } catch (IOException e) {
    }
  }
    
    // Method Cari peminjaman pada peminjaman.txt
    @Override
  public List<Peminjaman> cariPeminjaman(String keyword) {
    List<Peminjaman> hasil = new ArrayList<>();
    String key = keyword.toLowerCase();

    for (Peminjaman p : bacaSemuaPeminjaman()) {

        boolean cocok =
            p.getIdPinjam().toLowerCase().contains(key) ||
            p.getKodeBuku().toLowerCase().contains(key) ||
            p.getIdAnggota().toLowerCase().contains(key) ||
            p.getTanggalPinjam().toString().contains(key) ;
            
        if (cocok) {
            hasil.add(p);
        }
    }
    return hasil;
}
    
    private void simpanUlangPeminjaman(List<Peminjaman> list) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("peminjaman.txt"))) {
        for (Peminjaman p : list) {
            bw.write(p.toDataString());
            bw.newLine();
        }
    } catch (IOException e) {
    }
}

    
    public void kembalikanBuku(String idPinjam, String kodeBuku) {

        List<Peminjaman> list = bacaSemuaPeminjaman(); // ← INI WAJIB

    for (Peminjaman p : list) {
        if (p.getIdPinjam().equals(idPinjam)) {
            p.setStatus(StatusPinjam.DIKEMBALIKAN);
            break;
        }
    }

    simpanUlangPeminjaman(list);

    // update status buku
    ubahStatusBuku(kodeBuku, StatusBuku.TERSEDIA);
}

    public int getJumlahBuku() {
    return bacaSemua().size();
}

public int getJumlahAnggota() {
    return bacaSemuaAnggota().size();
}

public int getJumlahDipinjam() {
    int total = 0;
    for (Peminjaman p : bacaSemuaPeminjaman()) {
        if (p.getStatus() == StatusPinjam.DIPINJAM) {
            total++;
        }
    }
    return total;
}

public int getJumlahDikembalikan() {
    int total = 0;
    for (Peminjaman p : bacaSemuaPeminjaman()) {
        if (p.getStatus() == StatusPinjam.DIKEMBALIKAN) {
            total++;
        }
    }
    return total;
}





    public void simpan(Object b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

