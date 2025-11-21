package demo_cashier_versi_oop;
import java.io.*;
import java.util.*;

public class Main {
	public static boolean confirmation(String message) { 
		// membuat argument untuk bertanya
		 Scanner terminalInput = new Scanner(System.in);
		System.out.print("\n" + message + "(y|n)?");
		String pilihanUser = terminalInput.next();
		while(! pilihanUser.equalsIgnoreCase("y") && ! pilihanUser.equalsIgnoreCase("n")) { 
			System.err.println("Pilihan anda bukan y atau n");
			System.out.print("\n" + message + " y|n");
			pilihanUser = terminalInput.next();
		}
		// mengembalikan nilai y
		return pilihanUser.equalsIgnoreCase("y");
	} 
	public static void main(String[] args) {

	    Scanner terminalInput = new Scanner(System.in);
	    boolean isLanjutkan = true;

	    Product productModel = new Product(); // seperti Laravel Model

	    System.out.println("==== Aplikasi Kasir berbasis Desktop ====");

	    while (isLanjutkan) {

	        System.out.println("\n========== MENU UTAMA ==========");
	        System.out.println("1. Lihat data produk");
	        System.out.println("2. Cari data produk");
	        System.out.println("3. Tambah data produk");
	        System.out.println("4. Ubah data produk");
	        System.out.println("5. Hapus data produk");
	        System.out.println("========================================");
	        System.out.print("Pilih menu: ");

	        String jawaban = terminalInput.next();

	        switch (jawaban) {

	        case "1": 
	            System.out.println("\n=== LIST PRODUK ===");

	            List<Product> allProducts = productModel.all();
	            if (allProducts.isEmpty()) {
	                System.out.println("Tidak ada data.");
	            } else {
	                for (Product p : allProducts) {
	                    System.out.println(p.getKode() + " | " + p.getNama() + " | " + p.getHarga());
	                }
	            }
	            break;

	        case "2":
	            System.out.println("\n=== CARI PRODUK ===");

	            System.out.print("Masukkan kode produk: ");
	            String kodeCari = terminalInput.next();

	            Product hasil = productModel.find(kodeCari);

	            if (hasil != null) {
	                System.out.println("Ditemukan:");
	                System.out.println(hasil.getKode() + " | " + hasil.getNama() + " | " + hasil.getHarga());
	            } else {
	                System.out.println("Produk tidak ditemukan.");
	            }
	            break;

	        case "3":
	            System.out.println("\n=== TAMBAH PRODUK ===");
	            System.out.print("Kode: ");
	            String k = terminalInput.next();

	            System.out.print("Nama: ");
	            String n = terminalInput.next();

	            System.out.print("Harga: ");
	            int h = terminalInput.nextInt();

	            Product baru = new Product(k, n, h);
	            productModel.create(baru);

	            System.out.println("Berhasil menambah data.");
	            break;

	        case "4":
	            System.out.println("\n=== UBAH PRODUK ===");

	            System.out.print("Kode produk yang diubah: ");
	            String kodeUbah = terminalInput.next();

	            Product beforeUpdate = productModel.find(kodeUbah);
	            if (beforeUpdate == null) {
	                System.out.println("Produk tidak ditemukan.");
	                break;
	            }

	            System.out.print("Nama baru: ");
	            String namaBaru = terminalInput.next();

	            System.out.print("Harga baru: ");
	            int hargaBaru = terminalInput.nextInt();

	            Product updated = new Product(kodeUbah, namaBaru, hargaBaru);
	            productModel.update(updated);

	            System.out.println("Data berhasil diubah.");
	            break;

	        case "5":
	            System.out.println("\n=== HAPUS PRODUK ===");

	            System.out.print("Kode produk yang dihapus: ");
	            String kodeHapus = terminalInput.next();

	            boolean deleted = productModel.delete(kodeHapus);

	            if (deleted) {
	                System.out.println("Produk berhasil dihapus.");
	            } else {
	                System.out.println("Produk tidak ditemukan.");
	            }
	            break;

	        default:
	            System.out.println("Pilihan tidak valid.");
	        }

	        isLanjutkan = confirmation("Apakah ingin melanjutkan?");
	    }

	    System.out.println("Program selesai.");
	}

}
