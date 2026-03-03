package academic.model;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private char grade; // Menggunakan char untuk grade A, B, C, D, E

    public Course(String code, String name, int credits, char grade) {
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

    public char getGrade() {
        return grade;
    }

    // Method untuk format output sesuai permintaan
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
