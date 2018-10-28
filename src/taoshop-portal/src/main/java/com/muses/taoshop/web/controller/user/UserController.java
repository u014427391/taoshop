package com.muses.taoshop.web.controller.user;

import com.muses.taoshop.web.controller.BaseController;
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
 *    修改后版本:     修改人：  修改日期: 2018.08.11 11:08    修改内容:
 * </pre>
 */
@RequestMapping("/portal/user")
@Controller
public class UserController extends BaseController{

    /**
     * 跳转用户中心
     * @return
     */
    @GetMapping("/toUserCenter")
    public ModelAndView toUserCenter(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("user/portal_user_center");
        return mv;
    }
}
