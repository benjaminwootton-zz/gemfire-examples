package opencredo;

import com.gemstone.gemfire.Statistics;
import com.gemstone.gemfire.StatisticsFactory;
import com.gemstone.gemfire.StatisticsTypeFactory;
import com.gemstone.gemfire.StatisticsType;
import com.gemstone.gemfire.cache.CacheStatistics;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.distributed.DistributedSystem;
import com.gemstone.gemfire.internal.StatisticsTypeImpl;
import com.gemstone.gemfire.internal.cache.CachePerfStats;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Peer {

    private final static String REGION_BEAN_NAME = "sampleRegion";
    private final static String DISTRIBUTED_SYSTEM_BEAN_NAME = "distributedSystem";


    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        printBasicRegionStatistics(context);
        printDistributedSystemStatistics(context);
    }

    private static void printDistributedSystemStatistics(ApplicationContext context) {
        DistributedSystem distributedSystem = (DistributedSystem) context.getBean(DISTRIBUTED_SYSTEM_BEAN_NAME);

        // WIP
        CachePerfStats ps = new CachePerfStats(distributedSystem);
        System.out.println("xxps.getEntries() = " + ps.getLoadTime());
    }

    private static void printBasicRegionStatistics(ApplicationContext context) {
        Region sampleRegion = (Region) context.getBean(REGION_BEAN_NAME);

        System.out.println(String.format("Adding two items to region [%s]", REGION_BEAN_NAME));
        sampleRegion.put("A", System.currentTimeMillis());
        sampleRegion.put("B",System.currentTimeMillis());

        System.out.println(String.format("Performing some gets from [%s]", REGION_BEAN_NAME));
        sampleRegion.get("A");
        sampleRegion.get("C");
        sampleRegion.get("B");

        CacheStatistics cacheStatistics = sampleRegion.getStatistics();
        System.out.println("cacheStatistics.getHitCount() = " + cacheStatistics.getHitCount());
        System.out.println("cacheStatistics.getHitRatio() = " + cacheStatistics.getHitRatio());
        System.out.println("cacheStatistics.getMissCount() = " + cacheStatistics.getMissCount());
        System.out.println("cacheStatistics.getLastAccessedTime() = " + cacheStatistics.getLastAccessedTime());
        System.out.println("cacheStatistics.getLastModifiedTime() = " + cacheStatistics.getLastModifiedTime());

        cacheStatistics.resetCounts();
    }
}
