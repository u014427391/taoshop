package com.muses.taoshop.manager.web.controller.item;

import com.muses.taoshop.manager.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  订单管理控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 11:08    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{


    /**
     * 跳转订单管理页面
     * @return
     */
    @GetMapping(value = "/toOrder")
    public ModelAndView toOrder() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("admin/order/order_list");
        return mv;
    }



}
