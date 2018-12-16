package com.muses.taoshop.common.core.database.config;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.common.core.database.annotation.TypeAliasesPackageScanner;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;

import java.io.IOException;
import java.util.*;

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

@MapperScan(
        basePackages = MAPPER_PACKAGES,
        annotationClass = MybatisRepository.class,
        sqlSessionFactoryRef = SQL_SESSION_FACTORY
)
@ComponentScan
@EnableTransactionManagement
@Configuration
//@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
//@ConditionalOnBean(DataSource.class)
//@EnableConfigurationProperties(MybatisProperties.class)
//@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class MybatisConfig {


    @Autowired
    MybatisSqlInterceptor interceptor;

    TypeAliasesPackageScanner packageScanner = new TypeAliasesPackageScanner();

    @Bean(name = DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES)
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATA_SOURCE_NAME)DataSource dataSource)throws Exception{
        //SpringBoot默认使用DefaultVFS进行扫描，但是没有扫描到jar里的实体类
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setPlugins(new Interceptor[]{interceptor});
        factoryBean.setDataSource(dataSource);
        //factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            factoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*Mapper.xml"));
            //String typeAliasesPackage=setTypeAliasesPackage(ENTITY_PACKAGES);
            String typeAliasesPackage = packageScanner.getTypeAliasesPackages();
            factoryBean.setTypeAliasesPackage(typeAliasesPackage);
            SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
            return sqlSessionFactory;
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