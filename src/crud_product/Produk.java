package crud_product;

public class Produk {
	// registrasi nama properti produk
	public String nama;
	public String kode;
	public int harga;
	
	// membuat constructor
	public Produk(String kode, String nama, int harga) { 
		this.kode = kode;
		this.nama = nama;
		this.harga = harga;
	}
	
	// membuat fungsi setter
	public void setNama(String nama) { 
		this.nama = nama;
	} 
	
	public String getNama() { 
		return this.nama;
	}
	
	// membuat fungsi setter
	public void setKode(String kode) { 
		this.kode = kode;
	} 
	
	public String getKode() { 
		return this.kode;
	}
	
	
	// membuat fungsi setter
	public void setHarga(int harga) { 
		this.harga = harga;
	} 
	
	public int getHarga() { 
		return this.harga;
	}
}







