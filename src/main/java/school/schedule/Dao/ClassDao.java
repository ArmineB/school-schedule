package school.schedule.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import school.schedule.dto.Clazz;
import school.schedule.mapper.ClassMapper;

import java.sql.PreparedStatement;
import java.sql.*;

/**
 * Created by Armine on 20/07/2017.
 */

public enum ClassDao {
    Instance;

    private Connection conn;


      ClassDao() {
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


//   public Integer getClassIdByClassNumber(String classNumber){
//
//        final String sql = "select * from Class where ClassNumber= ?";
//        return jdbcTemplate.queryForObject(sql, new ClassMapper(), classNumber).getClassId();
//    }
//
//    public String getClassByClassId(Integer classId){
//
//        final String sql = "select * from Class where ClassId= ?";
//        return jdbcTemplate.queryForObject(sql, new ClassMapper(), classId).getClassNumber();
//    }


    public Integer getClassIdByClassNumber(String classNumber) {
        Integer classId = null;
        final String sql = "SELECT ClassId FROM class where ClassNumber= ?";
        try {
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,classNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
while (resultSet.next()) {
    classId = resultSet.getInt("ClassId");

}
        } catch (SQLException e) {
            System.out.println("Unable to get classId");
            e.printStackTrace();
        }
        return classId;
    }


}
