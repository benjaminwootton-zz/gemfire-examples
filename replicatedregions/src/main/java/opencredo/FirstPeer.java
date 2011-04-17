package opencredo;

import com.gemstone.gemfire.cache.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class FirstPeer {

    private final static String REGION_BEAN_NAME = "sampleRegion";
    private final static int BATCH_SIZE = 50;
    private final static int TIME_PERIOD = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        System.out.println(String.format("Populating region [%s] with [%s] items every [%s] seconds",
                REGION_BEAN_NAME, BATCH_SIZE, TIME_PERIOD));

        Region sampleRegion = (Region) context.getBean(REGION_BEAN_NAME);

        while( true ) {

            Thread.sleep(TIME_PERIOD);
            System.out.println(String.format("Region [%s] contains [%s] items", REGION_BEAN_NAME, sampleRegion.size()));

            for (int index = 0; index < BATCH_SIZE; ++index) {
                sampleRegion.put(System.currentTimeMillis()+index, System.currentTimeMillis());
            }

        }
    }
}
