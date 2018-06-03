package com.muses.taoshop.common.core.database.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <pre>
 *  TODO 定义一个元注解类扫描repository接口类
 *  @see @link org.mybatis.spring.mapper.MapperScannerConfigurer}
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MybatisRepository {
    String value() default "";
}
