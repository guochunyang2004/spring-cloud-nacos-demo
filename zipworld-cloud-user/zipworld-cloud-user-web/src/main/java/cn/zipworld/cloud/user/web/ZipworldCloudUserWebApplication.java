package cn.zipworld.cloud.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages ={
        "cn.zipworld"})
@EnableDiscoveryClient
public class ZipworldCloudUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipworldCloudUserWebApplication.class, args);
    }

}
