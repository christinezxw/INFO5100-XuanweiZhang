package assignment6Q5;

public class Main {

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1)); // returns 1
        System.out.println(map.get(3)); // returns -1 (not found)
        map.put(2, 1); // update the existing value
        System.out.println(map.get(2)); // returns 1
        map.remove(2); // remove the mapping for 2
        System.out.println(map.get(2)); // returns -1 (not found)

    }

}
