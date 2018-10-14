package com.muses.taoshop.web.controller.cart;

import com.muses.taoshop.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  购物车控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.17 00:46    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/portal/shopcart")
public class ShopCartController extends BaseController{

    /**
     * 添加购物车成功
     * @return
     */
    @GetMapping(value = "/toAddSuccess")
    public ModelAndView toAddSuccess() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("/shopcart/add_shopcart_success");
        return mv;
    }

}
