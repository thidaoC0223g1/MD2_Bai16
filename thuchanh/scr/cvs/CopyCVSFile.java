package cvs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyCVSFile {
    public static void main(String[] args) {
        String str1="E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt\\cvs.txt";
        String str2="E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\txt\\desination.txt";

        Path source = Paths.get(str1);
        Path target = Paths.get(str2);
        try{
            File f= new File(str2);
            if (f.exists()){
                throw new FileAlreadyExistsException(str2);
            }
            Files.copy(source,target);
            System.out.println("copy done");
        }catch(FileAlreadyExistsException e){
            System.err.println("file already exists "+ e.getMessage());
        }catch(FileNotFoundException e){
            System.out.println();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }


    }

}
