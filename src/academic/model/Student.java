package academic.model;

/**
 * @author 12S24032 Angga B. P. Sinipar
 */
public class Student {
    private String id;
    private String name;
    private String year; // Menggunakan String untuk tahun angkatan
    private String major;

    public Student(String id, String name, String year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    // Method untuk format output sesuai permintaan
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}
