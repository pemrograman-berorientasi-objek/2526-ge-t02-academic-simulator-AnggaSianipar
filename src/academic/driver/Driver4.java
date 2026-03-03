package academic.driver;

/**
 * @author 12S24032 Angga B. P. Sianipar
 */

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.ArrayList;
import java.util.List; // Menggunakan List interface
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        // Menggunakan satu List<Object> untuk menyimpan semua jenis record agar urutan input terjaga
        List<Object> records = new ArrayList<>(); 

        System.out.println("Masukkan data (course-add#... atau student-add#... atau enrollment-add#...). Ketik '---' untuk berhenti:");

        String line;
        while (true) {
            line = inputScanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            // Memecah baris input. Split dengan limit 2 agar bagian setelah command tidak terpecah lebih lanjut
            String[] commandAndData = line.split("#", 2); 
            
            // Memastikan setidaknya ada command dan data yang menyertainya
            if (commandAndData.length >= 2) {
                String command = commandAndData[0];
                String dataString = commandAndData[1];
                
                // Memecah string data menjadi segmen-segmen individual
                String[] dataSegments = dataString.split("#"); 

                switch (command) {
                    case "course-add":
                        // Memastikan ada 4 segmen data (setelah command)
                        if (dataSegments.length == 4) {
                            String code = dataSegments[0];
                            String name = dataSegments[1];
                            int credits = Integer.parseInt(dataSegments[2]);
                            String grade = dataSegments[3]; // Grade sekarang String
                            records.add(new Course(code, name, credits, grade));
                        } else {
                            System.err.println("Peringatan: Format input 'course-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    case "student-add":
                        // Memastikan ada 4 segmen data (setelah command)
                        if (dataSegments.length == 4) {
                            String id = dataSegments[0];
                            String name = dataSegments[1];
                            String year = dataSegments[2]; // PERBAIKAN: Mengambil tahun sebagai String
                            String major = dataSegments[3];
                            records.add(new Student(id, name, year, major)); // PERBAIKAN: Memanggil konstruktor dengan String year
                        } else {
                            System.err.println("Peringatan: Format input 'student-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    case "enrollment-add":
                        // Memastikan ada 4 segmen data (setelah command)
                        if (dataSegments.length == 4) {
                            String courseCode = dataSegments[0];
                            String studentId = dataSegments[1];
                            String academicYear = dataSegments[2];
                            String semester = dataSegments[3];
                            records.add(new Enrollment(courseCode, studentId, academicYear, semester));
                        } else {
                            System.err.println("Peringatan: Format input 'enrollment-add' tidak sesuai. Baris ini akan dilewati: " + line);
                        }
                        break;
                    default:
                        System.err.println("Peringatan: Perintah tidak dikenal. Baris ini akan dilewati: " + line);
                        break;
                }
            } else {
                System.err.println("Peringatan: Baris input kosong atau tidak valid (tidak ada command). Baris ini akan dilewati: " + line);
            }
        }

        // Menampilkan semua data yang telah diinput sesuai urutan penerimaan
        System.out.println("\n--- Data Tersimpan ---");
        for (Object record : records) {
            // Karena semua model memiliki method toString() yang sesuai, kita bisa langsung memanggilnya
            System.out.println(record.toString());
        }

        inputScanner.close();
    }
}
