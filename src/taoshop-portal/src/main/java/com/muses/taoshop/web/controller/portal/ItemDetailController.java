package com.muses.taoshop.web.controller.portal;

import com.muses.taoshop.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  商品详情页面控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.01 19:40    修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/item/detail")
public class ItemDetailController extends BaseController{

    @RequestMapping(value = "/toDetail.do")
    @GetMapping
    public ModelAndView toDetail(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("item/item_detail");
        return mv;
    }

}
