package crud_product;
// melakukan import Class Scanner
import java.util.Scanner;

// melakukan import class ArrayList
import java.util.ArrayList;

// melakukan import class File
import java.io.File;

// melakukan import class FileWriter
import java.io.FileWriter;

// melakukan import class file reader
import java.io.FileReader;

// melakukan import class BufferReader
import java.io.BufferedReader;

// melakukan import class IOException
import java.io.IOException;

public class Main {

	// inisialisasi class objek terminalInput
	public static Scanner terminalInput = new Scanner(System.in);
	
	// membuat fungsi menampilkan data produk
	public static void tampilkanDataProduct() throws IOException { 
		// melakukan instansiasi objek fileReader
		FileReader fileInput;
		BufferedReader bufferInput;
		
		try { 
			// mengambil file untuk dibaca
			fileInput = new FileReader("database-product.txt");
			bufferInput = new BufferedReader(fileInput);
			
		} catch(Exception error) { 
			System.out.println("DATABASE PRODUCT TIDAK DITEMUKAN");
			return;
		}
		
		// melakukan setting table untuk data produk
		String baris;
		System.out.println("====================================================================");
		System.out.printf("%-15s %-20s %-10s%n", "Kode Product", "Nama Product", "Harga Product");
		System.out.println("====================================================================");
	
		// melakukan perulangan data berdasar baris
		while((baris = bufferInput.readLine()) != null)  { 
			// masukkan kedalam array 
			String [] data = baris.split(",");
			// mengecek kondisi jumlah rownya
			if(data.length == 3) { 
				System.out.printf("%-15s %-20s %-10s%n", data[0].trim(), data[1].trim(), data[2].trim());
			}
		}
		System.out.println("====================================================================");
	
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		boolean isLanjutkan = true;
		
		// membuat objek arrayList dari produk
		ArrayList< Produk > listProduct =  new ArrayList<>();
		
		// membuat objek file 
		File fileOutput = new File("database-product.txt");
		
		// pengecekan fileOutput ada atau tidak
		if(fileOutput.createNewFile()) { 
			System.out.println("File created succesefully");
		} else { 
			System.out.println("File already exists");
		}
		// membuat argument nama aplikasi
		System.out.println("==== Aplikasi Kasir berbasis Desktop ====");
		
		// melakukan perulangan menggunakan while
		while(isLanjutkan) { 
			// membuat 5 menu
			System.out.println("\t 1. lihat data produk");
			System.out.println("\t 2. cari data produk");
			System.out.println("\t 3. Tambah data produk");
			System.out.println("\t 4. Ubah data produk");
			System.out.println("\t 5. Hapus data produk");
			System.out.print("Pilih menu berapa? ");
			String jawaban = terminalInput.next();
			
			// membuat pilihan menggunakan switch-case
			switch(jawaban) { 
			case "1":
				System.out.println("LIHAT LIST PRODUK");
				// fungsi untuk melihat seluruh product
				tampilkanDataProduct();
			break;
			
			case "2":
				System.out.println("LIHAT LIST PRODUK");
				// fungsi untuk melihat seluruh product
			break;
			
			case "3":
				System.out.println("LIHAT LIST PRODUK");
				// fungsi untuk melihat seluruh product
			break;
			
			case "4":
				System.out.println("LIHAT LIST PRODUK");
				// fungsi untuk melihat seluruh product
			break;
			
			case "5":
				System.out.println("LIHAT LIST PRODUK");
				// fungsi untuk melihat seluruh product
			break;
			
			default:
				System.out.println("Pilihan anda tidak sesuai");
			break;
			}
			
			// fungsi untuk konfirmasi
		} 
	}

}








