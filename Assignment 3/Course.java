import java.util.Arrays;

public class Course {

    private int courseId;
    private String courseName;
    private int maxCapacity = 100;
    private int professorId;
    private int credits;
    private int[] studentIds = new int[maxCapacity];
    private int studentCount;

    public Course(int courseId){
        setCourseId(courseId);
    }

    public Course(int courseId, int professorId){
        setCourseId(courseId);
        setProfessorId(professorId);
    }

    public Course(int courseId, int professorId, int credits){
        setCourseId(courseId);
        setProfessorId(professorId);
        setCredits(credits);
    }

    public void registerStudent(int studentId){
        if(studentCount >= maxCapacity)
            studentIds = removeDuplicates(studentIds);
        studentIds[studentCount++] = studentId;
    }

    public int[] removeDuplicates(int[] studentIds) {
        int[] newStudentArr = new int[maxCapacity];
        int sc = 0;
        for (int i=0; i<studentCount; i++) {
            if (!containsStudentId(newStudentArr,studentIds[i])) {
                newStudentArr[i] = studentIds[i];
                sc++;
            }
        }
        if(sc == studentCount)
            throw new IllegalStateException("New students cannot be enrolled. " +
                    "Course has reached its max capacity");
        studentCount = sc;
        return newStudentArr;
    }

    private boolean containsStudentId(int[] newStudentArr, int studentId) {
        for(int id : newStudentArr)
            if(id == studentId)
                return true;
        return false;
    }

    public int groupsOfStudents(int[] studentIds) {
        int count = 0;
        for(int i=0; i<studentCount; i++){
            for(int j=i+1; j<studentCount; j++){
                if((studentIds[i]+studentIds[j]) % 2 == 0)
                    count++;
            }
        }
        return count;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if(courseId <= 0)
            throw new IllegalArgumentException("Course Id cannot be less than or equal to zero.");
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        int n = courseName.length();
        if(n < 10 || n > 60)
            throw new IllegalArgumentException("Course name length should not be less than 10 or greater than 60.");
        this.courseName = courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity < 10 || maxCapacity > 100)
            throw new IllegalArgumentException("Max Capacity should be between or equal to 10 and 100.");
        this.maxCapacity = maxCapacity;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        if(professorId < 100_000 || professorId > 999_999)
            throw new IllegalArgumentException("Professor ID should contain six digits");
        this.professorId = professorId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if(credits < 1 || credits > 9)
            throw new IllegalArgumentException("Credit should be between 0 to 10.");
        this.credits = credits;
    }

    public int[] getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

}

