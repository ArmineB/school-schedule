package school.schedule.dto;

/**
 * Created by Armine on 20/07/2017.
 */
public class Subject {
    private  Integer subjectId;
    private  String name;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject(Integer subjectId, String name) {

        this.subjectId = subjectId;
        this.name = name;
    }
}
