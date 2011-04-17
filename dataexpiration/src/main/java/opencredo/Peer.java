package opencredo;

import com.gemstone.gemfire.cache.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Peer {

    private final static String REGION_BEAN_NAME = "sampleRegion";

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Region sampleRegion = (Region) context.getBean(REGION_BEAN_NAME);

        System.out.println("Putting 100 items into the cache");

        for( int index = 0 ; index < 100 ; ++index ) {
            sampleRegion.put(index,System.currentTimeMillis());
        }

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));

        sampleRegion.size();

        System.out.println("Sleeping");
        System.in.read();
    }
}
