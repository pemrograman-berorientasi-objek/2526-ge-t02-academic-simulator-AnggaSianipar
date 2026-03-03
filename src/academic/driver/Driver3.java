package academic.driver;

/**
 * @author 12S24032 Angga B. P. Sinipar
 */
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Enrollment> enrollments = new ArrayList<>(); // Menggunakan ArrayList untuk penyimpanan dinamis

        System.out.println("Masukkan data enrollment (kode_mk#nim#tahun_akademik#semester). Ketik '---' untuk berhenti:");

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
                String courseCode = segments[0];
                String studentId = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(enrollment);
            } else {
                // Menangani kasus jika segmen tidak 4, tanpa validasi error eksplisit ke user
                System.err.println("Peringatan: Format input tidak sesuai. Baris ini akan dilewati: " + line);
            }
        }

        // Menampilkan semua data enrollment yang telah diinput
        System.out.println("\n--- Data Enrollment Tersimpan ---");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        inputScanner.close();
    }
}
