package school.schedule.dto;

/**
 * Created by Armine on 20/07/2017.
 */
public class Teacher {
    private  Integer teacherId;
    private String firstName;
    private  String lastName;
    private Integer subjectId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public Teacher(String firstName, String lastName, Integer subjectId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Teacher(Integer teacherId, String firstName, String lastName, Integer subjectId) {

        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
    }
}
