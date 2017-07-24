package school.schedule.mapper;

import org.springframework.jdbc.core.RowMapper;
import school.schedule.dto.Clazz;
import school.schedule.dto.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 20/07/2017.
 */
public class SubjectMapper implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer subjectId = resultSet.getInt("SubjectId");
        String  name = resultSet.getString("name");
        Subject subject = new Subject(subjectId,name);
        return  subject;
    }
}
