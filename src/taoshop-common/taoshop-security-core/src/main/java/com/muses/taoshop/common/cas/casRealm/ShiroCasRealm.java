package com.muses.taoshop.common.cas.casRealm;

import org.apache.shiro.cas.CasRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * <pre>
 *  CASRealm类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.11.03 16:59    修改内容:
 * </pre>
 */
public class ShiroCasRealm extends CasRealm{

    private static final Logger log = LoggerFactory.getLogger(ShiroCasRealm.class);

    @PostConstruct
    public void initProperty() {

    }

}
