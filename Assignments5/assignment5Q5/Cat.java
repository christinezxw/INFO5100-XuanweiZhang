package assignment5Q5;

public class Cat extends Pet implements Boardable {

    private String hairLength;
    private int startDate;
    private int endDate;

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return "CAT:\n" + super.toString() + "\nHair: " + hairLength;
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
