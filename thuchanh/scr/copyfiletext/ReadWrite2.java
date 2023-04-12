package copyfiletext;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class ReadWrite2 {
    public static void main(String[] args) {
        ReadWrite2 rw2 = new ReadWrite2();
        rw2.readWrite();
    }

    public void readWrite() {
        String source = "E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt\\source.txt";
        String end = "E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt/end.txt";
        try {
            File f = new File(end);
            if (f.exists()) {
                throw new FileAlreadyExistsException("end.txt");
            }
            InputStream is = new FileInputStream(source);
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            OutputStream os = new FileOutputStream(end);
            BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(os));
            String line;
            while ((line = bis.readLine()) != null) {
                bos.write(line);
                bos.newLine();
            }
            bis.close();
            bos.close();
            System.out.println("copy done");
        } catch (FileAlreadyExistsException e) {
            System.err.println("file already exists " + e.getMessage());
        }
        catch(FileNotFoundException e){
            System.err.println("file not found " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("file not allowd" + e.getMessage());
        }
    }
}


