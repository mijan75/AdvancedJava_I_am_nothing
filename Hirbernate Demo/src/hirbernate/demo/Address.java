/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirbernate.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mijanur
 */
@Entity
public class Address {
    @Id
    String id;
    String presentAdrress;
    String permanentAddress;
    @ManyToOne
    Student student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    

    public Address() {
    }

    public Address(String id,String presentAdrress, String permanentAddress) {
        this.id = id;
        this.presentAdrress = presentAdrress;
        this.permanentAddress = permanentAddress;
    }

    public String getPresentAdrress() {
        return presentAdrress;
    }

    public void setPresentAdrress(String presentAdrress) {
        this.presentAdrress = presentAdrress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public String toString() {
        return "Adress{" + "presentAdrress=" + presentAdrress + ", permanentAddress=" + permanentAddress + '}';
    }
}
