package bd.ac.seu.collections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Student> studentList;
    private List<Course> courseList;
    private List<Grade> gradeList;


    private ResultSet resultSet1;
    private ResultSet resultSet2;
    private ResultSet resultSet3;

    private Connection connection;
    private Statement statement;

    public Main() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final String DBURL = "jdbc:mysql://localhost/predictdb";
            final String USERNAME = "root";
            final String PASSWORD = "ayesha75";

            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            String query1 = "SELECT * FROM student";
            resultSet1 = statement.executeQuery(query1);
            studentList = new ArrayList<>();

            while (resultSet1.next()) {
                studentList.add(new Student(resultSet1.getString("studentId"), resultSet1.getString("studentName")));
            }

            String query2 = "Select * from course";
            courseList = new ArrayList<>();
            resultSet2 = statement.executeQuery(query2);

            while(resultSet2.next()){
                courseList.add(new Course(resultSet2.getString("courseCode"), resultSet2.getString("courseTitle"), resultSet2.getDouble("credits")));
            }

            String query3 = "Select * from grades";
            gradeList = new ArrayList<>();
            resultSet3 = statement.executeQuery(query3);

            while(resultSet3.next()){
                gradeList.add(new Grade(resultSet3.getString("studentId"), resultSet3.getString("courseCode"), resultSet3.getString("facultyInitials"),resultSet3.getString("grade"), resultSet3.getInt("semesterId")));
            }

            int maxSize = 0;
            int index = 0;

            for(int i=0; i<studentList.size(); i++){
                int tempSize = studentList.get(i).getStudentName().length();

                if(tempSize > maxSize){
                    maxSize = tempSize;
                    index = i;
                }
            }
            System.out.println("The longest name is: " + studentList.get(index).getStudentName());

            for(int i=0; i<studentList.size(); i++){
                String id = studentList.get(i).getStudentId();

                for(int j=0; j<gradeList.size(); j++){
                    if(gradeList.get(j).getStudentId().equals(id)){
                        studentList.get(i).getGradeList().add(gradeList.get(j));
                    }
                }
            }

            for(int i=0; i<studentList.size(); i++){
                if(studentList.get(i).getStudentId().equals("13814")){
                    System.out.println(studentList.get(i));
                }
            }

/*
    Homework:
    1. Find out the student with the longest name
    2. Read course data from the database and save them into a list of courses
    3. Add a list of grades for each student and populate the student object with their own grades
 */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
