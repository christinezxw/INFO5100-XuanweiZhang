package assignment5Q5;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pet pet = new Pet("Spot", "Mary", "Black and White");
        pet.setSex(0);
        System.out.println(pet);

        Cat cat = new Cat("Tom", "Boob", "black", "short");
        cat.setSex(2);
        System.out.println(cat);
        cat.setBoardStart(10, 1, 2010);
        cat.setBoardEnd(1, 9, 2015);
        System.out.println(cat.boarding(5, 21, 2019));

        Dog dog = new Dog("Tom", "Boob", "black", "medium");
        dog.setSex(2);
        System.out.println(dog);
        dog.setBoardStart(10, 1, 2010);
        dog.setBoardEnd(5, 21, 2019);
        System.out.println(dog.boarding(1, 9, 2015));

    }

}
