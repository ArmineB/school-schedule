package school.schedule.Dao;



import java.sql.*;

/**
 * Created by Armine on 20/07/2017.
 */

public enum  SubjectDao {
    Instance;
   private Connection conn;


   SubjectDao(){
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



    public Integer getSubjectIdByName(String name){
        Integer subjectId = null;
        final String sql = "SELECT * FROM subject where Name= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subjectId = resultSet.getInt("SubjectId");
            }
        } catch (SQLException e) {
            System.out.println("Unable to get subjectId");
            e.printStackTrace();
        }
        return subjectId;
    }

    public String getSubjectNameById(Integer id){
        String subjectName = null;
        final String sql = "SELECT Name FROM subject where SubjectId= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subjectName = resultSet.getString("Name");
            }
        } catch (SQLException e) {
            System.out.println("Unable to get subjectName");
            e.printStackTrace();
        }
        return subjectName;
    }


}
