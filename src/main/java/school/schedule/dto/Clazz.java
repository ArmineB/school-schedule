package school.schedule.dto;

/**
 * Created by Armine on 20/07/2017.
 */
public class Clazz {
    private Integer classId;
    private String classNumber;

    public Clazz(Integer classId, String classNumber) {
        this.classId = classId;
        this.classNumber = classNumber;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
