package com.rina.exercise;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient
@SpringBootApplication
public class RobbionLoadbaianceApplication {

    @Bean
    // @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        // 多线程测试代码,测试luckygame。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 300; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    RestTemplate template = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Authorization", "Basic cmluYTpyaW5h");
                    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
                    String openId = UUID.randomUUID().toString();
                    String root = "https://dis.xixilz.com/luckygame/players/";
                    String rootLocal = "http://localhost:8080/players/";
                    String url = rootLocal + openId + "/gameOver";
                    template.exchange(url, HttpMethod.GET, entity, String.class);
                    String url2 = rootLocal + openId + "/predefinedMascot?mascot=盆景";
                    template.exchange(url2, HttpMethod.GET, entity, String.class);
                    String url4 = rootLocal + openId + "/predefinedMascot?mascot=杯子";
                    template.exchange(url4, HttpMethod.GET, entity, String.class);
                    String url5 = rootLocal + openId + "/predefinedMascot?mascot=女孩";
                    template.exchange(url5, HttpMethod.GET, entity, String.class);
                    String url3 = rootLocal + openId + "/qrCode";
                    template.exchange(url3, HttpMethod.GET, entity, String.class);
                }
            });
        }
        SpringApplication.run(RobbionLoadbaianceApplication.class, args);
    }
}
