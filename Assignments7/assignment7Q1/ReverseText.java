package assignment7Q1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class ReverseText {

    public static void main(String[] args) throws Exception {
        File readFile = new File("src/assignment7Q1/readFile.txt");
        FileInputStream fis = new FileInputStream(readFile);
        File writeFile = new File("src/assignment7Q1/writeFile.txt");
        FileOutputStream fos = new FileOutputStream(writeFile, true);
        PrintStream ps = new PrintStream(fos);
        Stack<String> buff = new Stack<String>();
        String temp = "";
        while (true) {
            int win = fis.read();
            if (win == -1) {
                break;
            }
            char cin = (char) win;
            if (cin != ' ') {
                temp += cin;
            } else {
                buff.add(temp + ' ');
                temp = "";
            }
        }
        buff.add(temp + ' ');
        while (!buff.empty()) {
            ps.print(buff.pop());
        }
        ps.close();
        fos.close();
        fis.close();

    }

}
