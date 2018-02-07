import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class MultiThreadConcurrentRT {
    @Bean
    // @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 300; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    RestTemplate template = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("hybris-tenant", "tenantIT");
                    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
                    String rootLocal = "http://localhost:8080/";
                    String pub = "/public/v2/customers";
                    String ui = "/ui/v2/v1/customers";
                    String s2s = "/s2s/v2/v1/customers";
                    String qurey = "?expand=all";
                    String url = rootLocal + pub + qurey;
                    template.exchange(url, HttpMethod.GET, entity, String.class);
                    String url2 = rootLocal + ui + qurey;
                    template.exchange(url2, HttpMethod.GET, entity, String.class);
                    String url4 = rootLocal + s2s + qurey;
                    template.exchange(url4, HttpMethod.GET, entity, String.class);
                }
            });
        }
    }

}
