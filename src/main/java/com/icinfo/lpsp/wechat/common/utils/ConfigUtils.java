package com.icinfo.lpsp.wechat.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置工具
 */
public class ConfigUtils {

    private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);

    /**
     * properties 对象 .
     */
    private static Properties pros = null;

    /**
     * 配置文件路径，文件名及路径约定 .
     */
    private static final String CONFIG_PATH = "/sysConfig.properties";

    /**
     * 加载配置文件
     *
     * @return 文件对应的Properties对象
     */
    private static Properties load() {
        // 已加载后无需再次加载
        if (pros == null) {
            pros = new Properties();
            InputStream in = ConfigUtils.class.getResourceAsStream(CONFIG_PATH);
            try {
                pros.load(in);
            } catch (IOException e) {
                logger.error("加载配置文件异常", e);
            }
        }
        return pros;
    }

    /**
     * 获取配置
     *
     * @param key 属性名称
     * @return 属性值
     */
    public static String getConfig(String key) {
        return ConfigUtils.load().getProperty(key);
    }

    /**
     * 获取配置，提供默认值
     *
     * @param key          属性名称
     * @param defaultValue 默认属性值，没有对应属性名称是返回该默认值
     * @return 属性值
     */
    public static String getConfig(String key, String defaultValue) {
        return ConfigUtils.load().getProperty(key, defaultValue);
    }
}
