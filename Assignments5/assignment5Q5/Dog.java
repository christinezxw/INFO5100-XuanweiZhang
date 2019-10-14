package assignment5Q5;

public class Dog extends Pet implements Boardable {
    private String size;
    private int startDate;
    private int endDate;

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "DOG:\n" + super.toString() + "\nSize: " + size;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startDate = year * 10000 + month * 100 + day;
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endDate = year * 10000 + month * 100 + day;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        return year * 10000 + month * 100 + day <= this.endDate && year * 10000 + month * 100 + day >= this.startDate;
    }

}
