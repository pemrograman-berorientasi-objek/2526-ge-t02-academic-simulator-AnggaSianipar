package academic.model;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Tipe data grade adalah String

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
