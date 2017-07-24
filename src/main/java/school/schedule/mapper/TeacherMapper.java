package school.schedule.mapper;

import org.springframework.jdbc.core.RowMapper;
import school.schedule.dto.Clazz;
import school.schedule.dto.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 22/07/2017.
 */
public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer teacherId = resultSet.getInt("TeacherId");
        String  firstName = resultSet.getString("FirstName");
        String  lastName = resultSet.getString("LastName");
        Integer subjectId = resultSet.getInt("SubjectId");
       Teacher teacher = new Teacher(teacherId, firstName, lastName, subjectId);
       return teacher;
    }
}
