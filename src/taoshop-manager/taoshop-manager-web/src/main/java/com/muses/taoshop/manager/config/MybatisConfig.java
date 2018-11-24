package com.muses.taoshop.manager.config;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
@EnableTransactionManagement
@Configuration
//@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
//@ConditionalOnBean(DataSource.class)
//@EnableConfigurationProperties(MybatisProperties.class)
//@AutoConfigureAfter(DataSourceAutoConfiguration.class)
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
        //SpringBoot默认使用DefaultVFS进行扫描，但是没有扫描到jar里的实体类
        //VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            factoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*Mapper.xml"));
            String typeAliasesPackage=setTypeAliasesPackage(ENTITY_PACKAGES);
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

    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    public static String setTypeAliasesPackage(String typeAliasesPackage) {
        ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
                resolver);
        typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + ClassUtils.convertClassNameToResourcePath(typeAliasesPackage)
                + "/" + DEFAULT_RESOURCE_PATTERN;
        try {
            List<String> result = new ArrayList<String>();
            Resource[] resources = resolver.getResources(typeAliasesPackage);
            if (resources != null && resources.length > 0) {
                MetadataReader metadataReader = null;
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        metadataReader = metadataReaderFactory
                                .getMetadataReader(resource);
                        try {
//                            System.out.println(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                            result.add(Class
                                    .forName(
                                            metadataReader.getClassMetadata()
                                                    .getClassName())
                                    .getPackage().getName());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (result.size() > 0) {
                HashSet<String> h = new HashSet<String>(result);
                result.clear();
                result.addAll(h);
                typeAliasesPackage=String.join(",",(String[]) result.toArray(new String[0]));
//                System.out.println(typeAliasesPackage);
            } else {
                throw new RuntimeException(
                        "mybatis typeAliasesPackage 路径扫描错误,参数typeAliasesPackage:"
                                + typeAliasesPackage + "未找到任何包");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return typeAliasesPackage;
    }

}