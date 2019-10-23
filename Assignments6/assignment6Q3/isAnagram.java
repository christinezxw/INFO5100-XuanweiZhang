package assignment6Q3;

import java.util.HashMap;

public class isAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(anagram(s, t));

    }

    public static boolean anagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            tMap.put(t.charAt(j), tMap.getOrDefault(t.charAt(j), 0) + 1);
        }
        return sMap.equals(tMap);
    }

}
