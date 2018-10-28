package com.muses.taoshop.sso.authentication;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;

import java.security.GeneralSecurityException;

/**
 * <pre>
 *  Cas单点登录用户名密码校验
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.08.19 22:16    修改内容:
 * </pre>
 */
public class UsernamePasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler{

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential usernamePasswordCredential) throws GeneralSecurityException, PreventedException {
        return null;
    }

    protected void doTest(){
        try{
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
