package com.muses.taoshop.web.controller.portal;

import com.muses.taoshop.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  商品类别控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.27 11:53    修改内容:
 * </pre>
 */
@Controller
@RequestMapping(value = "/portal/category")
public class ItemCategoryController extends BaseController{


    @RequestMapping(value = "/toCategoryList")
    public ModelAndView toCategoryList() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("item/item_category");
        return mv;
    }
}
