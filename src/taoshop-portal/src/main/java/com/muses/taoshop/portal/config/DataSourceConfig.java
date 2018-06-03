package com.muses.taoshop.portal.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.muses.taoshop.portal.config.BaseConfig.*;

/**
 * <pre>
 *  DataSource配置类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES)
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
