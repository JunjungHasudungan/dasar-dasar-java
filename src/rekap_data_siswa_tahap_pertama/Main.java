package rekap_data_siswa_tahap_pertama;
// Melakukan import class Scanner
import java.util.Scanner;

// melakukan import class ArrayList
import java.util.ArrayList;

// melakukan import file
import java.io.File;

// melakukan import file writer
import java.io.FileWriter;

// melakukan import try exception
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			// membuat file
			File fileOutput = new File("rekap-nilai-siswa.txt");
			
			// mengecek filenya sudah ada atau belum
			if(fileOutput.createNewFile()) {
				System.out.println("File created successfully");
			}else {
				System.out.println("File already exist");
			}
			
			// masukkan code sebelumnya kesini
			// melakukan instansiasi class Objek
			Scanner terminalInput = new Scanner(System.in);
			
			// Menangkap Inputan jumlah siswa
			System.out.print("Jumlah Siswa : ");
			int jumlah_siswa = terminalInput.nextInt();
			
			// Membuat array mapel
			String mapel[] = { "D.K.K", "INFORMATIKA" };
			
			// membuat nama objek arrayList
			ArrayList<Siswa> listNilaiSiswa = new ArrayList<>();
			
			// melakukan perulangan untuk mengambil nama siswa 
			for(int urutan = 0; urutan < jumlah_siswa; urutan++) { 
				
				// MELAKUKAN INSTANSIASI CLASS OBJEK DARI CLASS SISWA
				Siswa murid = new Siswa();
				
				System.out.println("\nSiswa #" + (urutan + 1));
				
				// MEMBERI ARGUMEN UNTUK MENANGKAP NAMA SISWA
				System.out.print("Nama: ");
				
				// menangkap inputan nama siswa dan memasukkan kedalam fungsi setNama
				murid.setNama(terminalInput.next());
				
				System.out.print("Kelas: ");
				murid.setKelas(terminalInput.next());
				
				// melakukan perulangan untuk array mapel
				for(int index_mapel = 0; index_mapel < mapel.length; index_mapel++) { 
					
					// menampilkan nama element mapel
					System.out.print("nilai " + mapel[index_mapel] + ": ");
					
					// melakukan if / percabangan / kondisi
					if(mapel[index_mapel].equals("D.K.K")) { 
						
						// menangkap inputan nilai dkk
						murid.setNilaiDkk(terminalInput.nextInt());
					}
					
					// melakukan if / percabangan / kondisi
					if(mapel[index_mapel].equals("INFORMATIKA")) { 
						
						// menangkap inputan nilai informatika
						murid.setNilaiInformatika(terminalInput.nextInt());
					}
				} 
				// menambahkan nilai kedalam objek murid
				listNilaiSiswa.add(murid);
				System.out.println();
			}
			
			// memberikan judul
			System.out.println("==== SISTEM REKAP NILAI SISWA ====");
			int index =  1;
			// MELAKUKAN PERULANGAN UNTUK MENAMPILKAN DATA DARI ARRAYLIST
			for(Siswa objectSiswa : listNilaiSiswa) { 
				// membuat urutan siswa 
				System.out.println("siswa ke #" + (index++ ));
				// menampilkan setiap nama siswa
				System.out.println("Nama \t " + objectSiswa.getNama());
			}
			
			// mengisi data kedalam file yang sudah dibuat
			FileWriter penForWrite = new FileWriter(fileOutput);
			int urutanSiswa = 1;
			// melakukan perulangan berdasarkan nama  array
			for(Siswa murid : listNilaiSiswa) { 
				// mencetak isi konten kefile perbaris
				penForWrite.write("Siswa #" + (urutanSiswa++) + "\n");
				penForWrite.write("Nama \t :" + murid.getNama() + "\n");
				//tampilkan nama kelas
				// nilai informatika
				// nilai dkk
				// nilai rata
				// nilai grade
			}
			penForWrite.close();
			System.out.println("");
			
		}catch(IOException error) {
			System.out.println("");
			error.printStackTrace();
		}
		
	}
}














