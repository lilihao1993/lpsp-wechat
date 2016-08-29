package com.icinfo.lpsp.wechat;

import com.icinfo.lpsp.wechat.common.config.SysConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动入口
 */
@EnableTransactionManagement
@EnableScheduling
@EnableConfigurationProperties({SysConfig.class})
@SpringBootApplication
public class FrameworkSbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(FrameworkSbootApplication.class, args);
	}
}
