package assignment7Q3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountLines {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file names that you want to count lines. Seperate with space:");
        String fileNames = scanner.nextLine();
        String[] files = fileNames.split(" ");
        for (int i = 0; i < files.length; i++) {
            try {
                int count = countLines("src/assignment7Q3/" + files[i]);
                System.out.println(files[i] + " has " + count + " lines.");
            } catch (FileNotFoundException e) {
                System.out.println(files[i] + " not found!");
            }
        }
        scanner.close();
    }

    public static int countLines(String filePath) throws Exception {
        int count = 0;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            BufferedReader br = new BufferedReader(isr);
            while (br.readLine() != null) {
                count++;
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            throw e;
        }
        return count;
    }

}
