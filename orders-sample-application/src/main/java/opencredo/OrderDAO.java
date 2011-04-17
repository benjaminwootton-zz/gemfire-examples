package opencredo;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: benjaminwootton
 * Date: 16/04/2011
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDAO {
    public void insertOrder(Order order);
    public ArrayList getOrders();


}
