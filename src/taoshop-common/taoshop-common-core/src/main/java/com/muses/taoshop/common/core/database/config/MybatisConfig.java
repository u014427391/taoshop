package com.muses.taoshop.common.core.database.config;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.resource.PathResourceResolver;

import javax.sql.DataSource;

import static com.muses.taoshop.common.core.database.config.BaseConfig.*;


/**
 * <pre>
 *  Mybatis配置类
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
@MapperScan(
        basePackages = MAPPER_PACKAGES,
        annotationClass = MybatisRepository.class,
        sqlSessionFactoryRef = SQL_SESSION_FACTORY
)
@EnableTransactionManagement
public class MybatisConfig {

    @Bean(name = DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES)
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATA_SOURCE_NAME)DataSource dataSource)throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            factoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/mapper/*Mapper.xml"));
            return factoryBean.getObject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Bean(name = MYBATIS_TRANSACTION_MANAGER)
    public DataSourceTransactionManager transactionManager(@Qualifier(DATA_SOURCE_NAME)DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}