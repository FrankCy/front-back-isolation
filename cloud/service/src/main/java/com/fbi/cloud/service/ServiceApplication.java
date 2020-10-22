package com.fbi.cloud.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * @author cy
 * @version ServiceApplication.java, v 0.1 2020年10月22日 14:06 cy Exp $
 */
@SpringBootApplication
@EnableDubbo
@ComponentScan("com.fbi.cloud")
@EntityScan("com.fbi.cloud.service.dao.entity")
@EnableJpaRepositories("com.fbi.cloud.service.dao.repository")
public class ServiceApplication {
    /**
     * 使用jar方式打包的启动方式
     */
    private static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServiceApplication.class, args).registerShutdownHook();
        COUNT_DOWN_LATCH.await();
    }
}
