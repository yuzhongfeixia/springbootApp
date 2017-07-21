package com.afis.appliction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.afis" })
@EnableScheduling//发现注解@Scheduled的任务并后台执行
@EnableTransactionManagement
public class AfisApplication {
	private static Logger logger = LoggerFactory.getLogger(AfisApplication.class);

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		ApplicationContext ctx = SpringApplication.run(AfisApplication.class, args);
		long end = System.currentTimeMillis();
		logger.info("============程序启动成功!      耗时间:{}毫秒==============", end - begin);
	}
}
