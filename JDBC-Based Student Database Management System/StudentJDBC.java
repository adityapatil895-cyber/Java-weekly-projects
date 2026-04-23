import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASS = "Birth@2004";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection(URL, USER, PASS);

        System.out.println("1.Add Student 2.View Students");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Course: ");
            String course = sc.nextLine();

            PreparedStatement ps =
                con.prepareStatement("INSERT INTO student VALUES (?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.executeUpdate();

            System.out.println("Student Inserted");
        } else {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3)
                );
            }
        }
        con.close();
    }
}