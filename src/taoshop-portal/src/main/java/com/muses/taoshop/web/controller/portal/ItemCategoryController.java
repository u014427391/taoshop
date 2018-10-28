package com.muses.taoshop.web.controller.portal;

import com.muses.taoshop.item.entity.ItemList;
import com.muses.taoshop.item.service.IItemCategoryService;
import com.muses.taoshop.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 *  商品品类控制类
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

    @Autowired
    IItemCategoryService iItemCategoryService;

    /**
     * 根据品类id检索商品信息
     * @param categoryId
     * @return
     */
    @GetMapping(value = "/toCategoryList/{categoryId}")
    public ModelAndView toCategoryList(@PathVariable("categoryId")int categoryId) {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("item/item_category");
        List<ItemList> items = iItemCategoryService.listItemByCategoryId(categoryId);
        mv.addObject("items", items);
        return mv;
    }


}
