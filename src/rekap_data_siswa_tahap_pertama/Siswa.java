package rekap_data_siswa_tahap_pertama;

public class Siswa {
	// PEMBUATAN PROPERTI GLOBAL TENTANG SISWA
	public String nama_siswa;
	public String kelas;
	public int umur;
	public int nilai_dkk;
	public int nilai_informatika;
	public int nilai_rata_rata;
	public String grade;
	
	// MEMBUAT FUNGSI SETTER
	public void setNama(String nama_siswa) { 
		this.nama_siswa = nama_siswa;
	}
	
	// MEMBUAT FUNGSI GETTER
	public String getNama() {
		return this.nama_siswa;
	}
	
	public void setNilaiDkk(int nilai_input_ddk) {
		this.nilai_dkk = nilai_input_ddk;
	}
	
	public void setKelas(String input_kelas) {
		this.kelas = input_kelas;
	}
	
	public String getKelas() {
		return this.kelas;
	}
	
	
	public int getNilaiDkk() {
		return this.nilai_dkk;
	}
	
	public int getNilaiInformatika() {
		return this.nilai_informatika;
	}
	
	public void setNilaiInformatika(int input_nilai_informatika) {
		this.nilai_informatika = input_nilai_informatika;
	}
	
	// fungsi untuk mencari nilai rata-tata 
	public int getNilaiRataRata() {
		return (this.nilai_dkk + this.nilai_informatika) /2;
	}
	
	// membuat fungsi mengecek grade dari rata-rata
	public String getPredicate() { 
		// mengambil nilai rata rata
		int total_rata_rata = this.getNilaiRataRata();
		
		// melakukan pengecekan melalui validasi 
		if(total_rata_rata > 95) { 
			this.grade = "A+";
		}
		// > 90 GRADE A
		// > 85 GRADE B+
		// > 80 GRADE B
		// > 75 GRADE C+ 
		// > 70 GRADE C
		// SELAIN ITU F  
		return this.grade;
	}
}













