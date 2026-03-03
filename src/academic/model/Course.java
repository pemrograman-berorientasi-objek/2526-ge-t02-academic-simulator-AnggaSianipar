package academic.model;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Tipe data grade diubah dari char menjadi String

    public Course(String code, String name, int credits, String grade) { // Konstruktor juga disesuaikan
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

    public String getGrade() { // Getter disesuaikan
        return grade;
    }

    // Method untuk format output sesuai permintaan
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
