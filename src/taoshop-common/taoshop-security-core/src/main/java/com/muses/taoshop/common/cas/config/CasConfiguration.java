package com.muses.taoshop.common.cas.config;

import com.muses.taoshop.common.security.core.shiro.realm.CommonShiroRealm;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *  单点登录配置类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.28 22:33    修改内容:
 * </pre>
 */
@Configuration
public class CasConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CasConfiguration.class);

    @Bean
    public CommonShiroRealm getShiroRealm() {
        CommonShiroRealm commonShiroRealm = new CommonShiroRealm();
        return commonShiroRealm;
    }

    /**
     * 单点登出监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new SingleSignOutHttpSessionListener());
        registrationBean.setEnabled(true);
        return registrationBean;
    }



}
