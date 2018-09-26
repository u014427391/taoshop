package com.muses.taoshop.manager.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muses.taoshop.manager.core.Constants;
import com.muses.taoshop.manager.entity.Menu;
import com.muses.taoshop.manager.entity.Permission;
import com.muses.taoshop.manager.entity.SysRole;
import com.muses.taoshop.manager.entity.SysUser;
import com.muses.taoshop.manager.service.ISysUserService;
import com.muses.taoshop.manager.util.MenuTreeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.naming.AuthenticationException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * <pre>
 *  登录控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.01 21:01    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/admin/login/api")
public class LoginController extends BaseController {

    @Autowired
    ISysUserService iSysUserService;

    @RequestMapping(value = "/toLogin")
    @GetMapping
    public ModelAndView toLogin(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 基于Shiro框架的登录验证,页面发送JSON请求数据，
     * 服务端进行登录验证之后，返回Json响应数据，"success"表示验证成功
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/loginCheck", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String loginCheck(HttpServletRequest request)throws AuthenticationException {
        JSONObject obj = new JSONObject();
        String errInfo = "";//错误信息
        String logindata[] = request.getParameter("LOGINDATA").split(",");
        if(logindata != null && logindata.length == 3){
            //获取Shiro管理的Session
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            String codeSession = (String)session.getAttribute(Constants.SESSION_SECURITY_CODE);
            String code = logindata[2];
            /**检测页面验证码是否为空，调用工具类检测**/
            if(StringUtils.isEmpty(code)){
                errInfo = "nullcode";
            }else{
                String username = logindata[0];
                String password = logindata[1];
                if(StringUtils.isNotEmpty(codeSession)/*&&code.equalsIgnoreCase(codeSession)*/){
                    //Shiro框架SHA加密
                    String passwordsha = new SimpleHash("SHA-1",username,password).toString();
                    System.out.println(passwordsha);
                    //检测用户名和密码是否正确
                    SysUser user = iSysUserService.getSysUser(username,passwordsha);
                    if(user != null){
                        if(Boolean.TRUE.equals(user.getLocked())){
                            errInfo = "locked";
                        }else{
                            //Shiro添加会话
                            session.setAttribute("username", username);
                            session.setAttribute(Constants.SESSION_USER, user);
                            //删除验证码Session
                            session.removeAttribute(Constants.SESSION_SECURITY_CODE);
                            //保存登录IP
                            //getRemortIP(username);
                            /**Shiro加入身份验证**/
                            Subject sub = SecurityUtils.getSubject();
                            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
                            sub.login(token);
                        }
                    }else{
                        //账号或者密码错误
                        errInfo = "uerror";
                    }
                    if(StringUtils.isEmpty(errInfo)){
                        errInfo = "success";
                    }
                }else{
                    //缺少参数
                    errInfo="codeerror";
                }
            }
        }
        obj.put("result", errInfo);
        return obj.toString();
    }

    /**
     * 后台管理系统主页
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/toIndex")
    public ModelAndView toMain() throws AuthenticationException{
        ModelAndView mv = this.getModelAndView();
        /**获取Shiro管理的Session**/
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser user = (SysUser)session.getAttribute(Constants.SESSION_USER);

        if(user != null){
            Set<SysRole> roles = user.getRoles();
            Set<Permission> permissions = new HashSet<Permission>();
            if(!CollectionUtils.isEmpty(roles)) {
                for (SysRole r : roles) {
                    permissions.addAll(r.getPermissions());
                }
            }

            /**获取用户可以查看的菜单**/
            List<Menu> menuList = new ArrayList<Menu>();
            for(Permission p : permissions){
                menuList.add(p.getMenu());
            }

            MenuTreeUtil treeUtil = new MenuTreeUtil();
            List<Menu> treemenus= treeUtil.menuList(menuList);

            String json = JSON.toJSONString(treemenus);

			json = json.replaceAll("menuId","id").replaceAll("parentId","pId").
					replaceAll("menuName","name").replaceAll("hasSubMenu","checked");

            mv.addObject("menus",json);
            mv.setViewName("admin/frame/index");
        }else{
            //会话失效，返回登录界面
            mv.setViewName("login");
        }

        return mv;
    }




}
