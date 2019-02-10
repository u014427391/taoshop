package com.muses.taoshop.common.core.database.annotation;

import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import static com.muses.taoshop.common.core.database.config.BaseConfig.ENTITY_PACKAGES;

/**
 * <pre>
 *  配置类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.12.01 18:30    修改内容:
 * </pre>
 */
public class AnnotationConstants {

    public static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    public final static String PACKAGE_PATTERN =
            ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
            + ClassUtils.convertClassNameToResourcePath(ENTITY_PACKAGES)
            + DEFAULT_RESOURCE_PATTERN;

}
