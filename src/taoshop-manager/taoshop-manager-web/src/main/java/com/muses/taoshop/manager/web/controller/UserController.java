package com.muses.taoshop.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  用户中心控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.08.11 11:06    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * 跳转到用户中心
     * @return
     */
    @GetMapping(value = "/toUserCenter")
    public ModelAndView toUserCenter() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("admin/user/user_center");
        return mv;
    }


}
