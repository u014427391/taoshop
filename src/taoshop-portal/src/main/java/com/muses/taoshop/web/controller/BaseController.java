package com.muses.taoshop.web.controller;


import org.apache.log4j.Logger;

/**
 * <pre>
 *  基础控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.18 00:12    修改内容:
 * </pre>
 */

public class BaseController {
    public Logger log = Logger.getLogger(getClass());


    public void debug(String message , Exception e){
        log.debug(message , e);
    }

    public void info(String message,Exception e){
        log.info(message , e);
    }

    public void error(String message,Exception e){
        log.error(message , e);
    }


}
