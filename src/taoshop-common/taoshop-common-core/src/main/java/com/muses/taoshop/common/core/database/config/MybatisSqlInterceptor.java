package com.muses.taoshop.common.core.database.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Properties;

/**
 * <pre>
 *  Mybatis SQL拦截器
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Component
@Intercepts(@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class MybatisSqlInterceptor implements Interceptor {

    Logger  LOGGER = LoggerFactory.getLogger(MybatisSqlInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拦截sql
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = statement.getBoundSql(parameterObject);
        String sql = boundSql.getSql();
        LOGGER.info("获取到的SQL：{}"+sql);
        if (StringUtils.isBlank(sql)) {
            return invocation.proceed();
        }
        // 返回
        return invocation.proceed();
    }
 
    @Override
    public Object plugin(Object obj) {
        return Plugin.wrap(obj, this);
    }
 
    @Override
    public void setProperties(Properties arg0) {}

}