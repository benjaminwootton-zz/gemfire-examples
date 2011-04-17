package opencredo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: benjaminwootton
 * Date: 16/04/2011
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class Order implements Serializable, Comparable {
    public String description;
    public String quantity;
    public float price;
    public Date creationDate;
    public String location;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int compareTo(Object o) {
        if( ((Order)o).getCreationDate().before(getCreationDate()) )
            return -1;
        return 1;
    }
}
