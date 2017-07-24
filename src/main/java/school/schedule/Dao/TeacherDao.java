package school.schedule.Dao;


import school.schedule.dto.Teacher;

import java.sql.*;

/**
 * Created by Armine on 20/07/2017.
 */

public enum TeacherDao {
    Instance;
    private Connection conn;


    TeacherDao(){
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



    public void add(Teacher teacher) {
        String query = "insert into teacher(FirstName, LastName, SubjectId) values(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setInt(3, teacher.getSubjectId());

            statement.execute();

        } catch (SQLException e) {
            System.out.println("Unable to add teacher");
            e.printStackTrace();
        }
    }


    public Integer getTeacherIdByNameAndSubject(String teacher, Integer subjectId) {
        Integer teacherId = null;
        final String sql = "select * from teacher where LastName= ? AND SubjectId= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,teacher);
            preparedStatement.setInt(2,subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teacherId = resultSet.getInt("TeacherId");
            }
        } catch (SQLException e) {
            System.out.println("Unable to get teacherId");
            e.printStackTrace();
        }
        return teacherId;
    }
}
