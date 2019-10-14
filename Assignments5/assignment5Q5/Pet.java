package assignment5Q5;

public class Pet {
    private String petName;
    private String ownerName;
    private String color;

    protected int sex;

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    public String getSex() {
        String res = "";
        switch (sex) {
        case 0:
            res = "MALE";
            break;
        case 1:
            res = "FEMALE";
            break;
        case 2:
            res = "SPAYED";
            break;
        case 3:
            res = "NEUTERED";
            break;
        }
        return res;
    }

    @Override
    public String toString() {
        return this.petName + " owned by " + this.ownerName + "\nColor: " + this.color + "\nSex: " + getSex();
    }

}
