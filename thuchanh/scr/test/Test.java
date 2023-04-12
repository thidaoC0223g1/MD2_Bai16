package test;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try {
            if(f.exists()){
                throw new IOException();
            }

            f.createNewFile();
            System.out.println("file already created "+ f.getAbsolutePath());
            System.out.println("file already created "+ f.getPath());
            System.out.println(f.length());

        }catch(IOException e){
            System.err.println("file already exists");
            e.printStackTrace();
        }
File folder =new File("test2/images");
        folder.mkdirs();

    }
}
