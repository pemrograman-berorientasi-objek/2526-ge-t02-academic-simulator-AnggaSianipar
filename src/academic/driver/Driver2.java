/**
 * @author 12S24032 Angga B. P. Sianipar
 */
package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>(); // Menggunakan ArrayList untuk penyimpanan dinamis

        String line;

        while (true) {
            line = inputScanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            // Memecah input menjadi 4 segmen
            String[] segments = line.split("#");

            // Memastikan input memiliki 4 segmen (tanpa validasi kesalahan, sesuai permintaan)
            if (segments.length == 4) {
                String id = segments[0];
                String name = segments[1];
                String year = segments[2];
                String major = segments[3];

                Student student = new Student(id, name, year, major);
                students.add(student);
            } else {
                // Menangani kasus jika segmen tidak 4, tanpa validasi error eksplisit ke user
                System.err.println("Peringatan: Format input tidak sesuai. Baris ini akan dilewati: " + line);
            }
        }


        for (Student student : students) {
            System.out.println(student.toString());
        }

        inputScanner.close();
    }
}