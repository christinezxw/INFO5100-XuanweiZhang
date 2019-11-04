package assignment7Q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class DecodeFile {

    public static void main(String[] args) throws Exception {
//        String encode = "2[abc]3[cd]ef";
//        System.out.println(decodeString(encode));
        File readFile = new File("src/assignment7Q2/readFile.txt");
        FileInputStream fis = new FileInputStream(readFile);
        File writeFile = new File("src/assignment7Q2/writeFile.txt");
        FileOutputStream fos = new FileOutputStream(writeFile, true);
        PrintStream ps = new PrintStream(fos);
        StringBuilder encode = new StringBuilder();
        while (true) {
            int x = fis.read();
            if (x == -1) {
                break;
            }
            char c = (char) x;
            encode.append(c);
        }
        String decode = decodeString(encode.toString());
        for (char c : decode.toCharArray()) {
            ps.print(c);
        }
        ps.close();
        fos.close();
        fis.close();
    }

    public static String decodeString(String encode) {
        String decode = "";
        int i = 0;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> worStack = new Stack<String>();
        while (i < encode.length()) {
            if (Character.isDigit(encode.charAt(i))) {
                int count = 0;
                while (Character.isDigit(encode.charAt(i))) {
                    count = count * 10 + (encode.charAt(i) - '0');
                    i++;
                }
                numStack.push(count);
            } else if (encode.charAt(i) == '[') {
                worStack.push(decode);
                i++;
                decode = "";
            } else if (encode.charAt(i) == ']') {
                int times = numStack.pop();
                StringBuilder temps = new StringBuilder(worStack.pop());
                int t = 0;
                while (t < times) {
                    temps.append(decode);
                    t++;
                }
                decode = temps.toString();
                i++;
            } else {
                decode += encode.charAt(i);
                i++;
            }
        }
        return decode;
    }

}
