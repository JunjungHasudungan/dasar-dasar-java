package demo_cashier_versi_oop;

import java.io.*;
import java.util.*;

public abstract class Model {

    protected String fileName; // setiap model punya file db sendiri

    public Model(String fileName) {
        this.fileName = fileName;
    }

    // Membaca seluruh baris file TXT
    protected List<String> readAll() {
        List<String> list = new ArrayList<>();

        try {
            File file = new File(fileName);
            if (!file.exists()) return list;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Menulis ulang seluruh isi file
    protected void writeAll(List<String> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String row : dataList) {
                writer.write(row);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete berdasarkan ID / kode
    public boolean delete(String code) {
        List<String> dataList = readAll();
        boolean found = false;

        Iterator<String> it = dataList.iterator();
        while (it.hasNext()) {
            String row = it.next();
            if (row.startsWith(code + ",")) {
                it.remove();
                found = true;
            }
        }

        if (found) {
            writeAll(dataList);
        }
        return found;
    }
}
