package school.schedule.Dao;


import school.schedule.dto.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
