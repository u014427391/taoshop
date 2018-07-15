package com.muses.taoshop.manager.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.muses.taoshop.manager.core.Constants;
import com.muses.taoshop.manager.entity.SysUser;
import com.muses.taoshop.manager.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import java.util.Random;

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
@RequestMapping("/admin")
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
//            Set<Role> roles = user.getRoles();
//            Set<Permission> permissions = new HashSet<Permission>();
//            for(Role r : roles){
//                permissions.addAll(r.getPermissions());
//            }
//
//            /**获取用户可以查看的菜单**/
//            List<Menu> menuList = new ArrayList<Menu>();
//            for(Permission p : permissions){
//                menuList.add(p.getMenu());
//            }

//            MenuTreeUtil treeUtil = new MenuTreeUtil();
//            List<Menu> treemenus= treeUtil.menuList(menuList);
//
//            JSONArray jsonArray = JSONArray.fromObject(treemenus);
//            String json = jsonArray.toString();

//			json = json.replaceAll("menuId","id").replaceAll("parentId","pId").
//					replaceAll("menuName","name").replaceAll("hasSubMenu","checked");

//            mv.addObject("menus",json);

        }else{
            //会话失效，返回登录界面
            mv.setViewName("admin/frame/login");
        }
        mv.setViewName("admin/frame/index");
        return mv;
    }


    @RequestMapping("/code/generate")
    public void generate(HttpServletResponse response){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(Constants.SESSION_SECURITY_CODE, code);

        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘画验证码
     * @param output
     * @return
     */
    private String drawImg(ByteArrayOutputStream output){
        String code = "";
        //随机产生4个字符
        for(int i=0; i<4; i++){
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman",Font.PLAIN,20);
        //调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66,2,82);
        g.setColor(color);
        g.setBackground(new Color(226,226,240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int)x, (int)baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 随机参数一个字符
     * @return
     */
    private char randomChar(){
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }

    /**
     * 获取随机颜色值
     * @param fc
     * @param bc
     * @return
     */
    Color getRandColor(int fc,int bc){
        Random random=new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }


}
