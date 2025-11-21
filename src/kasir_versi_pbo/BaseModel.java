package kasir_versi_pbo;
// melakukan import class library
import java.util.*;
import java.io.*;

public abstract class BaseModel {
	// registrasi nama file
	protected String fileName;
	
	// constructor BaseModel
	public BaseModel(String fileName) {
		this.fileName = fileName;
	}
	
	// membuat fungsi untuk membaca seluruh data
	protected List<String> readAll() {
		List<String> list = new ArrayList<>();
		try {
			// membuat objek file
			File file = new File(this.fileName);
			if(!file.exists()) { 
				return list; 
			}
			
			// membuat objek untuk membaca file
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			// membuat variable penampung data file
			String dataContentFile;
			
			// melakukan perulangan dari variable dataContentFile
			while((dataContentFile = reader.readLine()) != null) {  
				list.add(dataContentFile);
			} 
			
		} catch(IOException error) {
			error.printStackTrace();
		}
		
		return list;
	}
	// membuat fungsi untuk menulis seluruh inputan
	
	// membuat fungsi untuk menghapus
}
















