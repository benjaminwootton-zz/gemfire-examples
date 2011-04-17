package opencredo;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.distributed.DistributedSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: benjaminwootton
 * Date: 16/04/2011
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class OrderDAOGemFire implements OrderDAO {

    private DistributedSystem distributedSystem;

    private Region ordersRegion;

    public OrderDAOGemFire( DistributedSystem distributedSystem )
    {
        this.distributedSystem = distributedSystem;
        System.out.println("**** REQUEST TO CREATE BEAN *******" );
        if(null==ordersRegion){
            Cache cache = CacheFactory.create(distributedSystem);
            System.out.println("cache = " + cache);
            ordersRegion = cache.getRegion("ordersRegion");
            System.out.println("ordersRegion = " + ordersRegion);
        }
    }

    public void insertOrder(Order order) {
        ordersRegion.put(System.currentTimeMillis(),order);
    }

    public ArrayList getOrders() {
        return new ArrayList( ordersRegion.values() );
    }


}
