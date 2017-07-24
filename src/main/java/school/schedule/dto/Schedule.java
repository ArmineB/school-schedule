package school.schedule.dto;

/**
 * Created by Armine on 20/07/2017.
 */
public class Schedule {
    private Integer scheduleId;
    private Integer classId;
    private  Integer teacherId;
    private  Integer lessonTime;

    public Schedule(Integer scheduleId, Integer classId, Integer teacherId, Integer lessonTime) {
        this.scheduleId = scheduleId;
        this.classId = classId;
        this.teacherId = teacherId;
        this.lessonTime = lessonTime;
    }

    public Schedule(Integer classId, Integer teacherId, Integer lessonTime) {
        this.classId = classId;
        this.teacherId = teacherId;
        this.lessonTime = lessonTime;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Integer lessonTime) {
        this.lessonTime = lessonTime;
    }
}
