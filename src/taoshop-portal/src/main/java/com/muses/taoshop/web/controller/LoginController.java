package com.muses.taoshop.web.controller;

import com.muses.taoshop.user.entity.User;
import com.muses.taoshop.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.muses.taoshop.base.SessionConsts.PORTAL_SESSION_USER;
import static com.muses.taoshop.base.SessionConsts.SESSION_SECURITY_CODE;

/**
 * <pre>
 *  登录控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.08.05 11:41    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/portal")
public class LoginController extends BaseController{

    @Autowired
    IUserService userService;

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = "/toLogin")
    public ModelAndView toLogin(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 登录验证
     * @return
     */
    @RequestMapping(value = "/loginCheck")
    @ResponseBody
    public Map<String, String> loginCheck(HttpServletRequest request){
        Map<String, String> result = new HashMap<String, String>();
        String flag = "faild";
        String logindata[] = request.getParameter("LOGINDATA").split(",");
        HttpSession session = request.getSession();
        if(logindata != null && logindata.length == 3) {
            String codeSession = (String)session.getAttribute(SESSION_SECURITY_CODE);
            String username = logindata[0];
            String password = logindata[1];
            String code = logindata[2];
            //先不要验证码校验
            //if(!code.equalsIgnoreCase(codeSession)){//验证码校验
               // flag = "codeError";
            //}else{ //账号密码校验
                User user =  userService.loginCheck(username, password);
                if(user != null){//校验成功
                    session.setAttribute(PORTAL_SESSION_USER,username);
                    flag = "success";
                }else{//账号或者密码错误
                    flag = "faild";
                }
            //}
        }
        result.put("flag",flag);
        return result;
    }




}
