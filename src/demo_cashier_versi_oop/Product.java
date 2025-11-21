package demo_cashier_versi_oop;

import java.util.*;

public class Product extends Model {

    private String kode;
    private String nama;
    private int harga;

    public Product() {
        super("products.txt"); // nama file database
    }

    public Product(String kode, String nama, int harga) {
        super("products.txt");
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    // mirip Product::create([ ... ])
    public boolean create(Product p) {
        List<String> dataList = readAll();

        // Cek duplikasi kode
        for (String row : dataList) {
            if (row.startsWith(p.kode + ",")) {
                System.out.println("Kode sudah ada!");
                return false;
            }
        }

        String newRow = p.kode + "," + p.nama + "," + p.harga;
        dataList.add(newRow);
        writeAll(dataList);
        return true;
    }

    // mencari produk berdasarkan kode
    public Product find(String kode) {
        List<String> dataList = readAll();

        for (String row : dataList) {
            String[] dt = row.split(",");
            if (dt[0].equals(kode)) {
                return new Product(dt[0], dt[1], Integer.parseInt(dt[2]));
            }
        }
        return null;
    }

    // update 
    public boolean update(Product p) {
        List<String> dataList = readAll();
        boolean found = false;

        for (int i = 0; i < dataList.size(); i++) {
            String[] dt = dataList.get(i).split(",");

            if (dt[0].equals(p.kode)) {
                dataList.set(i, p.kode + "," + p.nama + "," + p.harga);
                found = true;
                break;
            }
        }

        if (found) writeAll(dataList);
        return found;
    }
    
    // READ ALL → return List<Product>
    public List<Product> all() {
        List<String> rows = readAll();
        List<Product> products = new ArrayList<>();

        for (String row : rows) {
            String[] parts = row.split(",");
            if (parts.length == 3) {
                String k = parts[0];
                String n = parts[1];
                int h = Integer.parseInt(parts[2]);
                products.add(new Product(k, n, h));
            }
        }
        return products;
    }

    // getter
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getHarga() { return harga; }
}
