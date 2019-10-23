package assignment6Q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class uniqueOccurrences {

    public static void main(String[] args) {
        int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(uniqueOccur(arr));

    }

    public static boolean uniqueOccur(int[] arr) {
        HashMap<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
        HashSet<Integer> occurSet = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>(arrMap.values());
        for (int j = 0; j < arrMap.values().size(); j++) {
            occurSet.add(list.get(j));
        }
        return arrMap.values().size() == occurSet.size();
    }

}
