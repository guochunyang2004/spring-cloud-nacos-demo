package cn.zipworld.cloud.product.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages ={"cn.zipworld.cloud"})
@EnableDiscoveryClient
//@MapperScan("cn.zipworld.cloud.product")
public class ZipworldCloudProductWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipworldCloudProductWebApplication.class, args);
    }

}
