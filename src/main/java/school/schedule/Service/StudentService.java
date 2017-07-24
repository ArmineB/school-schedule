package school.schedule.Service;


import school.schedule.Dao.ClassDao;
import school.schedule.Dao.StudentDao;
import school.schedule.dto.Student;

/**
 * Created by Armine on 20/07/2017.
 */

public class StudentService {
    private  final StudentDao studentDao = StudentDao.Instance;
    private final   ClassDao classDao = ClassDao.Instance;



    public void addStudent(String firstName, String lastName, String clazz) {
        Student student = new Student(firstName, lastName,classDao.getClassIdByClassNumber(clazz));
        studentDao.add(student);

    }
}
