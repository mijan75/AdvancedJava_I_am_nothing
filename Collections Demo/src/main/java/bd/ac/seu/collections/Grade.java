package bd.ac.seu.collections;

public class Grade {
    String studentId;
    String courseCode;
    String facultyInitial;
    String grade;
    int semesterId;

    public Grade() {
    }

    public Grade(String studentId, String courseCode, String facultyInitial, String grade, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitial = facultyInitial;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFacultyInitial() {
        return facultyInitial;
    }

    public void setFacultyInitial(String facultyInitial) {
        this.facultyInitial = facultyInitial;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitial='" + facultyInitial + '\'' +
                ", grade='" + grade + '\'' +
                ", semesterId=" + semesterId +
                '}'+'\n';
    }
}
