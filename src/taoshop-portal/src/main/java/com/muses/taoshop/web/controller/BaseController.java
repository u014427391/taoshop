package com.muses.taoshop.web.controller;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *  TODO 类说明
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
    public Logger log = null;

    /**
     * 获取日志对象
     * @return
     */
    public Logger getInstance(){
        if(log == null){
            log = (Logger) LoggerFactory.getLogger(BaseController.class);
        }
        return log;
    }
}
