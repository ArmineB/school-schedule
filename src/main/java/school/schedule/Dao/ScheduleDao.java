package school.schedule.Dao;

import com.sun.corba.se.pept.transport.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import school.schedule.dto.Schedule;

import java.sql.*;
import java.util.List;

/**
 * Created by Armine on 20/07/2017.
 */

public enum  ScheduleDao {
    Instance;
    private Connection conn;


    ScheduleDao() {
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




    public void add(Schedule schedule) {
        String query = "insert into schedule(ClassId, TeacherId, LessonTime) values(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1,schedule.getClassId());
            statement.setInt(2, schedule.getTeacherId());
            statement.setInt(3, schedule.getLessonTime());

            statement.execute();

        } catch (SQLException e) {
            System.out.println("Unable to add schedule");
            e.printStackTrace();
        }
    }

    public Schedule getScheduleByClassId(Integer classId) {
        Schedule schedule = null;
        final String sql = "SELECT TeacherId, LessonTime FROM schedule WHERE ClassId= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, classId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer teacherId = resultSet.getInt("TeacherId");
                Integer lessonTime = resultSet.getInt("LessonTime");

              schedule = new Schedule(classId, teacherId, lessonTime);

            }
        } catch (SQLException e) {
            System.out.println("Unable to get schedule");
            e.printStackTrace();
        }
        return schedule;
    }
}
