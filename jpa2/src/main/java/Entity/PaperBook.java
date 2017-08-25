package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaperBook extends Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private int shippingwieght;
    private int inStock;

    @Override
    public String toString() {
        return "Tester.Entity.PaperBook[ id=" + getId() + " ]";
    }
    
}
