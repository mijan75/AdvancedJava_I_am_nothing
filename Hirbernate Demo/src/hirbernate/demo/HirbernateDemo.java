/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirbernate.demo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mijanur
 */
public class HirbernateDemo {

    public HirbernateDemo() {
//        Student student = new Student ("1","Rifat");
//        //Adress address = new Adress("Rangpur", "Dhaka");
//        Address address = new Address("3","Rangpur", "Dhaka");
//        Address address1 = new Address("4","Bangladesh","Bangladesh");
//        address.setStudent(student);
//        address1.setStudent(student);
//        
//        System.exit(0);
//        
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        session.beginTransaction();
//        student = (Student) session.get(Student.class, "1");
//        session.delete(student);
//        //session.save(student);
//        //session.save(address);
//        session.getTransaction().commit();
//        session.close();  
          doSomething();
    }
    
    public void doSomething(){
        Student student1 = new Student(10,"Mijan");
        Student student2 = new Student(1,"Mijan");
        Student student3 = new Student(7,"Mijan");
        Student student4 = new Student(2,"Mijan");
        Student student5 = new Student(6,"Mijan");
        
        List<Student> studentList= new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        
        int sum = studentList.stream().filter(t -> t.getName().equals("Mijan")).mapToInt(t -> t.getId()).sum();
        System.out.println(sum);
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HirbernateDemo();
    }
    
}
