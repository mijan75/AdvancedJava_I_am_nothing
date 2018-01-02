/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirbernate.demo;

import javax.persistence.Embeddable;

/**
 *
 * @author mijanur
 */
@Embeddable
public class Adress {
    String presentAdrress;
    String permanentAddress;

    public Adress() {
    }

    public Adress(String presentAdrress, String permanentAddress) {
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
