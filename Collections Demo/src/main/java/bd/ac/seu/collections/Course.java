package bd.ac.seu.collections;

public class Course {
    String courseCode;
    String courseTitile;
    double credits;

    public Course() {
    }

    public Course(String courseCode, String courseTitile, double credits) {
        this.courseCode = courseCode;
        this.courseTitile = courseTitile;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitile() {
        return courseTitile;
    }

    public void setCourseTitile(String courseTitile) {
        this.courseTitile = courseTitile;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitile='" + courseTitile + '\'' +
                ", credits=" + credits +
                '}';
    }
}
