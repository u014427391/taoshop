<?xml version="1.0" encoding="UTF-8" ?>
<configuration debug="false" scan="true">
    <!-- 日志级别 -->
    <springProperty scope="context" name="LOG_ROOT_LEVEL" source="logging.level.root" defaultValue="DEBUG"/>
    <!--  标识这个"STDOUT" 将会添加到这个logger -->
    <springProperty scope="context" name="STDOUT" source="log.stdout" defaultValue="STDOUT"/>
    <!-- 日志格式，%d：日期；%thread：线程名；%-5level：日志级别从左显示5个字符长度，列如:DEBUG；
        %logger{36}：java类名，例如:com.muses.taoshop.MyTest，36表示字符长度；%msg：日志内容；%d：换行 -->
    <property name="LOG_PATTERN"
              value="%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n" />
    <!-- root日志级别-->
    <property name="${LOG_ROOT_LEVEL}" value="DEBUG" />
    <!-- 日志跟目录 -->
    <property name="LOG_HOME" value="data/logs" />
    <!-- 日志文件路径-->
    <property name="LOG_DIR" value="${LOG_HOME}/%d{yyyyMMdd}" />
    <!-- 日志文件名称 -->
    <property name="LOG_PREFIX" value="portal" />
    <!-- 日志文件编码 -->
    <property name="LOG_CHARSET" value="utf-8" />
    <!-- 配置日志的滚动时间，保存时间为15天-->
    <property name="MAX_HISTORY" value="15" />
    <!-- 文件大小，默认为10MB-->
    <property name="MAX_FILE_SIZE" value="10" />


    <!-- 打印到控制台 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- 格式化日志内容-->
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
        </encoder>
    </appender>
    <!-- 打印所有日志，保存到文件-->
    <appender name="FILE_ALL"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_HOME}/all_${LOG_PREFIX}.log</file>
        <!-- 设置滚动策略，当日志文件大小超过${MAX_FILE_SIZE}时，新的日志内容写到新的日志文件-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 新的日志文件路径名称，%d:日期 %i:i是变量 -->
            <fileNamePattern>${LOG_DIR}/all_${LOG_PREFIX}%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <!-- 保存日志15天 -->
            <maxHistory>${MAX_HISTORY}</maxHistory>
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <!-- 日志文件的最大大小 -->
                <maxFileSize>${MAX_FILE_SIZE}</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <!-- 格式日志文件内容-->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>${LOG_PATTERN}</pattern>
        </layout>
    </appender>

    <!-- 打印错误日志，保存到文件-->
    <appender name="FILE_ERR"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_HOME}/err_${LOG_PREFIX}.log</file>
        <!-- 设置滚动策略，当日志文件大小超过${MAX_FILE_SIZE}时，新的日志内容写到新的日志文件-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 新的日志文件路径名称，%d:日期 %i:i是变量 -->
            <fileNamePattern>${LOG_DIR}/err_${LOG_PREFIX}%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <!-- 保存日志15天 -->
            <maxHistory>${MAX_HISTORY}</maxHistory>
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <!-- 日志文件的最大大小 -->
                <maxFileSize>${MAX_FILE_SIZE}</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <!-- 格式日志文件内容-->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>${LOG_PATTERN}</pattern>
        </layout>
    </appender>

    <!-- rest template logger-->
    <!--<logger name="org.springframework.web.client.RestTemplate" level="DEBUG" />-->
    <!--<logger name="org.springframework" level="DEBUG" />-->

    <!-- jdbc-->
    <!--<logger name="jdbc.sqltiming" level="DEBUG" />-->
    <logger name="org.mybatis" level="DEBUG" />

    <!-- zookeeper-->
    <logger name="org.apache.zookeeper"    level="ERROR"  />

    <!-- dubbo -->
    <logger name="com.alibaba.dubbo.monitor" level="ERROR"/>
    <logger name="com.alibaba.dubbo.remoting" level="ERROR" />

    <!-- 日志输出级别 -->
    <root leve="${LOG_ROOT_LEVEL}">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE_ALL" />
        <appender-ref ref="FILE_ERR" />
    </root>

</configuration>