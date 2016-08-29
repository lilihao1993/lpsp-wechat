package com.icinfo.lpsp.wechat.common.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by yushunwei on 2016/7/19.
 */
@Configuration
public class MyBatisConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    /**
     * Mybatis分页插件
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        logger.info("注册MyBatis分页插件PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
