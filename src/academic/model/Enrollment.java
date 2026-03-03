package academic.model;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */
public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade; // Default ke "None" jika belum ada nilai

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Sesuai permintaan output default "None"
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Setter untuk grade, jika nanti diperlukan untuk update nilai
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method untuk format output sesuai permintaan
    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
