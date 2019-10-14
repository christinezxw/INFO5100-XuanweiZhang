package assignment5Q3;

public class Contractor extends Employee {

    private int workingHours;

    public Contractor(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return this.getPaymentPerHour() * this.workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

}
