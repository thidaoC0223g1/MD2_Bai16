package readoutfromtxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Scanner;


public class ReadFromTxt {

    public static void main(String[] args) {
        System.out.println("nhap vao duong dan file");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        ReadFromTxt reader = new ReadFromTxt();
        System.out.println(reader.readOutFromTxt(path));
    }

    public ArrayList<Integer> readOutFromTxt(String path) {
        ArrayList<Integer> ar1 = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(path));
            String row;
            while ((row = br.readLine()) != null) {
                String[] ar2 = row.split(",");
                String str = ar2[2].trim();
                ar1.add(Integer.parseInt(str));
                System.out.println(row);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("file not found");
        } catch (NumberFormatException e) {
            System.err.println("So khong hop le");
        } catch (Exception e) {
            System.err.println("file text error");
        }
        return ar1;
    }
}
