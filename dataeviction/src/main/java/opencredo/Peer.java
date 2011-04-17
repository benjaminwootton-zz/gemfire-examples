package opencredo;

import com.gemstone.gemfire.cache.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Peer {

    private final static String ENTRY_COUNT_CACHE_BEAN_NAME = "entryCountCacheRegion";
    private final static String MEMORY_SIZE_CACHE_BEAN_NAME = "memorySizeCacheRegion";
    private final static String HEAP_PCT_CACHE_BEAN_NAME = "heapPctCacheRegion";


    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        entryCountCacheDemo(context);
        memorySizeCacheDemo(context);
        maximumHeapPercentageCacheDemo(context);
    }

    private static void entryCountCacheDemo(ApplicationContext context) {
        Region sampleRegion = (Region) context.getBean(ENTRY_COUNT_CACHE_BEAN_NAME);

        System.out.println("Putting 1000 items into a cache configured to hold 10 most recently used objects");

        for( int index = 0 ; index < 1000 ; ++index ) {
            sampleRegion.put(index,System.currentTimeMillis());
        }

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));
    }


    private static void memorySizeCacheDemo(ApplicationContext context) {
        Region sampleRegion = (Region) context.getBean(MEMORY_SIZE_CACHE_BEAN_NAME);

        System.out.println("Putting 1000 items into a cache configured to hold least recent used objects in a cache of maximum 2mb of data");

        for( int index = 0 ; index < 10000 ; ++index ) {
            sampleRegion.put(index,new int[1000]);
        }

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));
    }


    private static void maximumHeapPercentageCacheDemo(ApplicationContext context) {
        Region sampleRegion = (Region) context.getBean(HEAP_PCT_CACHE_BEAN_NAME);

        System.out.println("Putting 1000 items into a cache configured to hold least recent used objects in a cache limited to 2% of total heap size");

        for( int index = 0 ; index < 10000 ; ++index ) {
            sampleRegion.put(index,new int[1000]);
        }

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));

        sampleRegion.size();
    }

}
