/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibiernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mijanur
 */
public class HibiernateDemo {

    public HibiernateDemo() {
        Student student = new Student(1,"Mijan");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HibiernateDemo();
    }
    
}
