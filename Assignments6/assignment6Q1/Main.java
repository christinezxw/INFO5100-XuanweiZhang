package assignment6Q1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // test cases
        ArrayList<String> user1 = new ArrayList<String>(
                Arrays.asList("Amy", "21", "1598th 3rd st", "2090006666", "AN123amy", "amypass1", "6000"));
        ArrayList<String> user2 = new ArrayList<String>(
                Arrays.asList("Bob", "42", "221th pl", "2091238888", "AN456bob", "bobpass1", "15000"));
        ArrayList<String> user3 = new ArrayList<String>(
                Arrays.asList("Jack", "36", "78th 1st ave", "2097773434", "AN789jack", "jackpass1", "800"));
        // data includes: name,age,address,phone,account,password,balance
        // initialize input
        ArrayList<ArrayList<String>> userData = new ArrayList<ArrayList<String>>();
        userData.add(user1);
        userData.add(user2);
        userData.add(user3);
        // test start
        Atm myAtm = new Atm(10000, 10, userData);
        myAtm.startService();
        System.out.println("login status: " + myAtm.isLogginStatus() + "\nTest end.");
    }

}
