package com.muses.taoshop.common.core.database.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.*;

import org.springframework.core.io.Resource;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import static com.muses.taoshop.common.core.database.annotation.AnnotationConstants.PACKAGE_PATTERN;

/**
 * <pre>
 *  TypeAlicsesPackage的扫描类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.12.01 18:23    修改内容:
 * </pre>
 */
@Component
public class TypeAliasesPackageScanner {

    protected final static Logger LOGGER = LoggerFactory.getLogger(TypeAliasesPackageScanner.class);
    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
   /* private TypeFilter[] entityTypeFilters = new TypeFilter[]{new AnnotationTypeFilter(Entity.class, false),
            new AnnotationTypeFilter(Embeddable.class, false),
            new AnnotationTypeFilter(MappedSuperclass.class, false),
            new AnnotationTypeFilter(org.hibernate.annotations.Entity.class, false)};*/


    public static String scanTypeAliasesPackage() {
        Set<String> classNames = new TreeSet<String>();
        TreeSet packageNames = new TreeSet();
        String typeAliasesPackage ="";
        try {
            Resource[] resources = resourcePatternResolver.getResources(PACKAGE_PATTERN);
            MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader reader = readerFactory.getMetadataReader(resource);
                    String className = reader.getClassMetadata().getClassName();
                    try{
                        classNames.add(Class.forName(className).getPackage().getName());
                    }catch (ClassNotFoundException e){
                        LOGGER.error("class not found exception..."+e);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("scan type aliases package exception : {}" + e);
        }
        if (!CollectionUtils.isEmpty(classNames)) {
            typeAliasesPackage = StringUtils.join(classNames.toArray() , ",");
        }else{
            LOGGER.info("can not scan packages,the set of classNames is empty...");
        }
        return typeAliasesPackage;
    }


}
