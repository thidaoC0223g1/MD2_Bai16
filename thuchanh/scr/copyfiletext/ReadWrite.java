package copyfiletext;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class ReadWrite {
    public static void main(String[] args) {
        ArrayList<String> ar;
        ReadWrite rw = new ReadWrite();
        ar =readFile("E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt\\source.txt");
        rw.copyFile("E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt\\recive.txt",ar);
    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> array = new ArrayList<>();
        try {
            File f = new File(path);
            if (!f.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                array.add(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("khong tim thay file nguon");
        } catch (Exception e) {
            System.err.println("File not found or something error");
        }

        return array;
    }

    public void copyFile(String path, ArrayList<String> array) {
        try {
            File f = new File(path);
            if (f.exists()) {
                throw new FileAlreadyExistsException("recive.txt");
            }
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String i : array) {
                bw.write(i);
                bw.newLine();
            }
            bw.close();

        } catch (FileAlreadyExistsException e) {
            System.err.println("file already exists " + e.getMessage());
        } catch (IOException e) {
            System.err.println("input error" + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred" + e.getMessage());
        }
    }
}
