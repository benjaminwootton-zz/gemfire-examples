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

        System.out.println(String.format("Adding two items to region [%s]", REGION_BEAN_NAME));

        sampleRegion.put(System.currentTimeMillis(),"A");
        sampleRegion.put(System.currentTimeMillis(),"B");

        System.out.println(String.format("Region now contains [%s] items", sampleRegion.size()));

        System.out.println("Sleeping");
        System.in.read();
    }
}
