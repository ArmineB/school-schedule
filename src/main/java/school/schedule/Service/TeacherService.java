package school.schedule.Service;


import school.schedule.Dao.SubjectDao;
import school.schedule.Dao.TeacherDao;
import school.schedule.dto.Teacher;

/**
 * Created by Armine on 20/07/2017.
 */

public class TeacherService {
    private  final TeacherDao teacherDao = TeacherDao.Instance;
    private final SubjectDao subjectDao = SubjectDao.Instance;

    public void addTeacher(String firstName, String lastName, String subject) {
        Teacher teacher = new Teacher(firstName, lastName, subjectDao.getSubjectIdByName(subject));
        teacherDao.add(teacher);

    }
}
