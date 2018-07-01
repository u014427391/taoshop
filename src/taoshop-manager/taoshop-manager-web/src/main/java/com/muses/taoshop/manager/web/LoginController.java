package com.muses.taoshop.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  TODO 类说明
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
public class LoginController extends BaseController{

    @RequestMapping(value = "/toLogin")
    @GetMapping
    public ModelAndView toLogin(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("login");
        return mv;
    }


}
