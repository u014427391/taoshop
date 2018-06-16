package com.muses.taoshop;



import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
/**
 *
 * <pre>
 *  SpringBoot启动配置类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Controller
@EnableScheduling//开启对计划任务的支持
@EnableTransactionManagement
@EnableCaching
@EnableAsync//开启对异步方法的支持
@EnableAutoConfiguration //TODO 修改该注解可以实现自动部署
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}