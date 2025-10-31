package demo_kasir;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Main {

	static Scanner terminalInput = new Scanner(System.in);
	
	public static void tampilkanData() throws IOException {
		// melakukan registrasi Object FileReader
		FileReader fileInput;
		BufferedReader bufferInput;
		
		try {
			
			fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
            
		}catch(Exception error) {
			System.out.println("Databaase tidak ditemukan..");
			return;
		}
		  String baris;
          System.out.println("===============================================");
          System.out.printf("%-15s %-20s %-10s%n", "Kode Produk", "Nama Produk", "Harga");
          System.out.println("===============================================");
          
//          bufferInput.readLine();

          while ((baris = bufferInput.readLine()) != null) {
              String[] data = baris.split(",");

              if (data.length == 3) {
                  System.out.printf("%-15s %-20s %-10s%n", data[0].trim(), data[1].trim(), data[2].trim());
              }
          }

          System.out.println("===============================================");
	}
	
	public static boolean confirmation(String message) {
		Scanner terminalInput = new Scanner(System.in);
		System.out.print("\n" + message + "(y|n)? ");
		String pilihanUser = terminalInput.next();
		while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
			System.err.println("Pilihan anda bukan y atau n");
			System.out.print("\n" + message + "y|n");
			pilihanUser = terminalInput.next();
		}
		return pilihanUser.equalsIgnoreCase("y");
	}
	
	public static void tambahDataProduct() {
		ArrayList<Product> arrayProduct = new ArrayList<>();
		
		System.out.print("Jumlah Product \t: ");
		int jumlah_product = terminalInput.nextInt();
		
		for(int index = 0; index < jumlah_product; index++) {
			System.out.println("Produk #" + (index + 1));
			// memasukkan kode produk
			System.out.print("Kode Product: ");
			String kodeProduct = terminalInput.next();
			
			
			// memasukakan nama product
			System.out.print("Nama Product: ");
			String namaProduct = terminalInput.next();
			
			// memasukkan harga product
			System.out.print("Harga Produk: ");
			int hargaProduct = terminalInput.nextInt();
			
			// masukkkan kedalam array List
			
			Product product = new Product(kodeProduct, namaProduct, hargaProduct);
			arrayProduct.add(product);
			System.out.println();
		}
		
		try {

			File fileOutput = new File("database.txt");
            FileWriter pena = new FileWriter(fileOutput, true);
			
    		// menulis kedalam file database
            for(Product produk : arrayProduct) {
            	pena.write("\n" + produk.getKodeProduct() +"," + produk.getNamaProduct() + "," + produk.getHargaProduct());
            }
            
            pena.close();
            System.out.println("Berhasil menambah data produk");
		}catch(IOException error) {
			System.out.println("");
			error.printStackTrace();
		}
		
	}
	
	public static void cariDataProduct() {
		System.out.println("MENCARI DARA PRODUCT");
	}
	
	public static void main(String[] args) throws IOException {
		boolean isLanjutkan  = true;
		
		ArrayList<Product> arrayProduct = new ArrayList<>();
		File fileOutput = new File("database.txt");
		 // mengecek file 
        if(fileOutput.createNewFile()) {
        	System.out.println("File created successfully");
        }else {
        	System.out.println("File already exist");
        }
		
		System.out.println("==== APLIKASI DEMO KASIR BERBASIS JAVA ==== ");
		
		while(isLanjutkan) {

			System.out.println("1.\tLihat list Produk");
			System.out.println("2.\tCari data Produk");
			System.out.println("3.\tTambah list Produk");
			System.out.println("4.\tUbah list Produk");
			System.out.println("5.\tHapus list Produk");
			System.out.print("Pilihan anda: ");
			String jawaban = terminalInput.next();
			
			switch(jawaban) {
				case "1":
					System.out.println("Lihat list Produk");
					tampilkanData();
				break;
				
				case "2":
					System.out.println("Cari Produk");
					cariDataProduct();
				break;
				
				case "3":
					System.out.println("Tambah Produk");
					tambahDataProduct();
				break;
				
				default:
					System.out.println("Pilihan anda tidak sesuai: ");
				break;
			}
			isLanjutkan = confirmation("Apakah anda ingin melanjutkan");
		}
		
		
	}

}
