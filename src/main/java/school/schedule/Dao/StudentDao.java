package school.schedule.Dao;


import school.schedule.dto.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armine on 20/07/2017.
 */

  public enum  StudentDao {
    Instance;

    private Connection conn;


    StudentDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_schedule",
                    "root", "");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load mysql driver");
            e.printStackTrace();
        }
    }


    public void add(Student student) {
        String query = "insert into student(FirstName, LastName, ClassId) values(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setInt(3, student.getClassId());

            statement.execute();

        } catch (SQLException e) {
            System.out.println("Unable to add student");
            e.printStackTrace();
        }
    }


    public List<Student> loadStudents() {
        List<Student> students = null;
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT FirstName, LastName, ClassId FROM student");

            students = new ArrayList<>();

            while (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                Integer classId = resultSet.getInt("ClassId");
                Student student = new Student(firstName, lastName, classId);

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Unable to get students");
            e.printStackTrace();
        }

        return students;
    }
}
