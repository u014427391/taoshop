package com.muses.taoshop.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@MapperScan("com.muese.taoshop.**.mapper*")
public class WebConfig extends WebMvcConfigurerAdapter {
  
    @Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");  
        super.addResourceHandlers(registry);  
    }


   /* @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MybatisSqlInterceptor());
        super.addInterceptors(registry);
    }*/


}  