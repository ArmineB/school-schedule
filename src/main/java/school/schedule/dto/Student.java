package school.schedule.dto;

/**
 * Created by Armine on 20/07/2017.
 */
public class Student {
    private Integer stuedntId;
    private  String firstName;
    private  String lastName;
    private  Integer classId;

    public Integer getStuedntId() {
        return stuedntId;
    }

    public Student(String firstName, String lastName, Integer classId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
    }

    public void setStuedntId(Integer stuedntId) {
        this.stuedntId = stuedntId;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Student(Integer stuedntId, String firstName, String lastName, Integer classId) {

        this.stuedntId = stuedntId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
    }
}
