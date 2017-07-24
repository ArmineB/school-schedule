package school.schedule.mapper;

import org.springframework.jdbc.core.RowMapper;
import school.schedule.dto.Clazz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 20/07/2017.
 */
public class ClassMapper implements RowMapper<Clazz> {
    @Override
    public Clazz mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer classId = resultSet.getInt("ClassId");
        String  classNumber = resultSet.getString("ClassNumber");
        Clazz clazz = new Clazz(classId,classNumber);
        return  clazz;
    }
}
