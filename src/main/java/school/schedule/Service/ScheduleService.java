package school.schedule.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.schedule.Dao.ClassDao;
import school.schedule.Dao.ScheduleDao;
import school.schedule.Dao.SubjectDao;
import school.schedule.Dao.TeacherDao;
import school.schedule.dto.Schedule;

/**
 * Created by Armine on 20/07/2017.
 */

public class ScheduleService {
    private  final ScheduleDao scheduleDao = ScheduleDao.Instance;
    private  final ClassDao classDao = ClassDao.Instance;
    private  final TeacherDao teacherDao = TeacherDao.Instance;
    private  final SubjectDao subjectDao = SubjectDao.Instance;


    public void addSchedule(String clazz, Integer lessonTime, String subject, String teacher) {
        Integer subjectId = subjectDao.getSubjectIdByName(subject);
        Schedule schedule = new Schedule(classDao.getClassIdByClassNumber(clazz),teacherDao.getTeacherIdByNameAndSubject(teacher,subjectId),lessonTime);
        scheduleDao.add(schedule);
    }
}
