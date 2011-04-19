package opencredo;

import com.gemstone.gemfire.cache.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Peer {

    private final static String REGION_BEAN_NAME = "sampleRegion";

    public static void main(String[] args) throws IOException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        entryCountCacheDemo(context);
    }

    private static void entryCountCacheDemo(ApplicationContext context) throws InterruptedException {
        Region sampleRegion = (Region) context.getBean(REGION_BEAN_NAME);

        System.out.println("Putting 10 items into a cache that will expire them after 5 seconds");

        for( int index = 0 ; index < 10 ; ++index ) {
            sampleRegion.put(index,System.currentTimeMillis());
        }

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));

        System.out.println("Sleeping for 6 seconds");

        Thread.sleep(6000);

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));
    }




}
