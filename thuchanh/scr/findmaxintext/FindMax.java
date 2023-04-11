package findmaxintext;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        System.out.println("nhap vao file");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        int i = findMax(readTxt(path));
        FindMax x = new FindMax();
        x.writeTxt("E:\\codegym2023\\Modun2\\Bai16\\thuchanh\\result2.txt", i);
    }
    public static ArrayList<Integer> readTxt(String path) {
        ArrayList<Integer> number = new ArrayList<>();
        try {
            File f = new File(path);
            if (!f.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(path));
            String row;
            while ((row = br.readLine()) != null) {
                number.add(Integer.parseInt(row));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (NumberFormatException e) {
            System.err.println("So khong hop le");
        } catch (Exception e) {
            System.err.println("File not found or other error");
        }
        return number;
    }
    public static int findMax(ArrayList<Integer> number) {
        int max = number.get(0);
        for (Integer i : number) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
    public void writeTxt(String path, int max) {
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("gia tri lon nhat=" + max);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
