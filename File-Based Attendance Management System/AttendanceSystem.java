import java.io.*;
import java.util.Scanner;

public class AttendanceSystem {

    static final String FILE_NAME = "attendance.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Mark Attendance 2.View Attendance 3.Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    FileWriter fw = new FileWriter(FILE_NAME, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    System.out.print("Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Status (Present/Absent): ");
                    String status = sc.nextLine();

                    bw.write(name + " - " + status);
                    bw.newLine();
                    bw.close();
                    System.out.println("Attendance Saved");
                    break;

                case 2:
                    BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                    break;
            }
        } while (choice != 3);
    }
}