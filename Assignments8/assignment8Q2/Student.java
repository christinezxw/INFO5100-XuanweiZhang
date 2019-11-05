package assignment8Q2;

public class Student implements Comparable {

    private String id;
    private String name;
    private String gender;

    public Student(String id, String name, String gender) {
        super();
        if (isNumeric(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Wrong input format!");
        }
        if (name.length() == 0 || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Wrong input format!");
        } else {
            this.name = name;
        }
        if (gender.equals("Male") || gender.equals("Female")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Wrong input format!");
        }

    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        Student s = (Student) o;
        return s.getId().equals(this.getId());
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.getId().compareTo(s.getId());
    }

}
