package com.muses.taoshop.manager.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 * Thymeleaf模板引擎配置
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 10:50    修改内容:
 * </pre>
 */
@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void addFormatters(final FormatterRegistry registry){
        super.addFormatters(registry);
        registry.addFormatter(dateFormatter());
    }

    @Bean
    public DateFormatter dateFormatter(){
        return new MyDateFormatter();
    }

    class MyDateFormatter extends DateFormatter {
        @Override
        public String print(Date date, Locale locale) {
            //return super.print(date, locale);
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }
    }
}
