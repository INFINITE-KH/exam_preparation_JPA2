/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author KH
 */
@Entity
public class EBook extends Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private String downloadUrl;
    private int sizeMB;

    @Override
    public String toString() {
        return "Tester.Entity.EBook[ id=" + getId() + " ]";
    }
    
}
