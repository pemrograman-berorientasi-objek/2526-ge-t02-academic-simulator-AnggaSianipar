package academic.driver;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */
import academic.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>(); // Menggunakan ArrayList karena array biasa memiliki ukuran tetap

        String line;
        System.out.println("Masukkan data course (kode#nama#sks#grade). Ketik '---' untuk berhenti:");

        while (true) {
            line = inputScanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            // Memecah input menjadi 4 segmen
            String[] segments = line.split("#");

            // Memastikan input memiliki 4 segmen (tanpa validasi kesalahan, sesuai permintaan)
            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                int credits = Integer.parseInt(segments[2]); // Asumsi input SKS selalu valid integer
                char grade = segments[3].charAt(0);          // Asumsi input grade selalu karakter tunggal

                Course course = new Course(code, name, credits, grade);
                courses.add(course);
            } else {
                // Menangani kasus jika segmen tidak 4, tanpa validasi error eksplisit ke user
                // Program akan tetap berjalan, hanya saja input yang salah format tidak diproses
                System.err.println("Peringatan: Format input tidak sesuai. Baris ini akan dilewati: " + line);
            }
        }

        // Menampilkan semua data course yang telah diinput
        System.out.println("\n--- Data Course Tersimpan ---");
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        inputScanner.close();
    }
}
