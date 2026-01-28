/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.util;

/**
 *
 * @author LENOVO
 */

   import perpustakaan.model.Buku;
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
    public void simpan(Buku b) {
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
    public List<Buku> bacaSemua() {
        List<Buku> list = new ArrayList<>();

        File file = new File(FILE);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                Buku b = new Buku(
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
    public List<Buku> cariBuku(String keyword) {
    List<Buku> hasil = new ArrayList<>();

    for (Buku b : bacaSemua()) {
        if (b.getJudul().toLowerCase().contains(keyword.toLowerCase())
            || b.getKode().toLowerCase().contains(keyword.toLowerCase())
            || b.getPenulis().toLowerCase().contains(keyword.toLowerCase())) {

            hasil.add(b);
        }
    }
    return hasil;
}
    
    //Method Edit Buku pada buku.txt
    public void updateBuku(Buku bukuBaru) {
    List<Buku> list = bacaSemua();

    try (BufferedWriter bw =
         new BufferedWriter(new FileWriter("buku.txt"))) {

        for (Buku b : list) {
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
            p.getTanggalKembali() + ";" +
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

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PEMINJAMAN))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(";");

            Peminjaman p = new Peminjaman(
                data[0], 
                data[1], 
                data[2], 
                data[3], 
                data[4], 
                StatusPinjam.valueOf(data[5])
            );
            list.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
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
    public List<Peminjaman> cariPeminjaman (String keyword) {
    List<Peminjaman> hasil = new ArrayList<>();

    for (Peminjaman p : bacaSemuaPeminjaman()) {
        if (p.getIdPinjam().toLowerCase().contains(keyword.toLowerCase())
            || p.getKodeBuku().toLowerCase().contains(keyword.toLowerCase())
            || p.getIdAnggota().toLowerCase().contains(keyword.toLowerCase())
            || p.getTanggalPinjam().toLowerCase().contains(keyword.toLowerCase())
            || p.getTanggalKembali().toLowerCase().contains(keyword.toLowerCase()))
        {

            hasil.add(p);
        }
    }
    return hasil;
}
    
    
}

