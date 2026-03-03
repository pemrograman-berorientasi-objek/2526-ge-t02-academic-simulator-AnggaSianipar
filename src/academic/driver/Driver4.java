package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Object> records = new ArrayList<>(); // Menggunakan List<Object> untuk menyimpan semua jenis data

        System.out.println("Masukkan data (course-add#... atau student-add#... atau enrollment-add#...). Ketik '---' untuk berhenti:");

        String line;
        while (true) {
            line = inputScanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            // Memecah input berdasarkan '#'
            String[] segments = line.split("#");

            if (segments.length > 0) {
                String command = segments[0];

                switch (command) {
                    case "course-add":
                        // Memastikan ada 5 segmen: command + 4 data course
                        if (segments.length == 5) {
                            String code = segments[1];
                            String name = segments[2];
                            int credits = Integer.parseInt(segments[3]);
                            String grade = segments[4]; // Mengambil seluruh string grade
                            Course course = new Course(code, name, credits, grade);
                            records.add(course);
                        } else {
                            System.err.println("Peringatan: Format input 'course-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    case "student-add":
                        // Memastikan ada 5 segmen: command + 4 data student
                        if (segments.length == 5) {
                            String id = segments[1];
                            String name = segments[2];
                            String year = segments[3];
                            String major = segments[4];
                            Student student = new Student(id, name, year, major);
                            records.add(student);
                        } else {
                            System.err.println("Peringatan: Format input 'student-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    case "enrollment-add":
                        // Memastikan ada 5 segmen: command + 4 data enrollment
                        if (segments.length == 5) {
                            String courseCode = segments[1];
                            String studentId = segments[2];
                            String academicYear = segments[3];
                            String semester = segments[4];
                            Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            records.add(enrollment);
                        } else {
                            System.err.println("Peringatan: Format input 'enrollment-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    default:
                        System.err.println("Peringatan: Perintah tidak dikenal. Baris ini akan dilewati: " + line);
                        break;
                }
            } else {
                System.err.println("Peringatan: Baris input kosong atau tidak valid. Baris ini akan dilewati: " + line);
            }
        }

        // Menampilkan semua data yang telah diinput sesuai urutan penerimaan
        System.out.println("\n--- Data Tersimpan ---");
        for (Object record : records) {
            System.out.println(record.toString());
        }

        inputScanner.close();
    }
}

