package com.muses.taoshop.web.controller;

import com.muses.taoshop.common.core.base.Constants;
import com.muses.taoshop.user.entity.User;
import com.muses.taoshop.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
            String codeSession = (String)session.getAttribute(Constants.SESSION_SECURITY_CODE);
            String username = logindata[0];
            String password = logindata[1];
            String code = logindata[2];
            if(!code.equalsIgnoreCase(codeSession)){//验证码校验
                flag = "codeError";
            }else{ //账号密码校验
                User user =  userService.loginCheck(username, password);
                if(user != null){//校验成功
                    session.setAttribute(Constants.SESSION_USER,username);
                    flag = "success";
                }else{//账号或者密码错误
                    flag = "faild";
                }
            }
        }
        result.put("flag",flag);
        return result;
    }

    @RequestMapping("/code/generate")
    public void generate(HttpServletRequest request,HttpServletResponse response){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);

//        Subject currentUser = SecurityUtils.getSubject();
//        Session session = currentUser.getSession();
        HttpSession session = request.getSession();
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
