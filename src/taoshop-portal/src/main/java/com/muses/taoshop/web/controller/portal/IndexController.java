package com.muses.taoshop.web.controller.portal;

import com.alibaba.fastjson.JSON;
import com.muses.taoshop.item.entity.ItemBrand;
import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.entity.ItemPortal;
import com.muses.taoshop.item.service.IItemBrankService;
import com.muses.taoshop.item.service.IItemCategoryService;
import com.muses.taoshop.item.service.IItemService;
import com.muses.taoshop.util.CategoryTreeUtils;
import com.muses.taoshop.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 *  门户网站控制类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Controller
@RequestMapping("/portal")
public class IndexController extends BaseController{

    @Autowired
    IItemService iItemService;
    @Autowired
    IItemBrankService iItemBrankService;
    @Autowired
    IItemCategoryService iItemCategoryService;

    /**
     * 跳转到门户网站
     * @return
     */
    @GetMapping(value = "/toIndex.do")
    public ModelAndView toIndex(){
        info("跳转到门户网站");
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("index");
        List<ItemPortal> items = iItemService.listItemPortal();
        CategoryTreeUtils treeUtil = new CategoryTreeUtils();
        List<ItemCategory> list = iItemCategoryService.listCategory();
        List<ItemCategory> categories = treeUtil.buildCategoryTree(list);
        mv.addObject("items" , items);
        mv.addObject("categories" , categories);
        return mv;
    }

    @GetMapping(value = "/doTest")
    @ResponseBody
    public  String doTest(){
        List<ItemBrand> itemBrands = iItemBrankService.listItemBrand();
        String str = JSON.toJSON(itemBrands).toString();
        return str;
    }

    /**
     * 加载root级商品品类
     * @return
     */
    @GetMapping(value = "/listCategory" , produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String listCategory(){
        CategoryTreeUtils treeUtil = new CategoryTreeUtils();
        List<ItemCategory> list = iItemCategoryService.listCategory();
        List<ItemCategory> categories = treeUtil.buildCategoryTree(list);
        for(ItemCategory itemCategory : categories){
            Date unixlongTime = itemCategory.getCreateTime();
            log.debug("create time!!!!!!!!!"+unixlongTime);
        }
        String jsonString = "";
        if(!CollectionUtils.isEmpty(categories)){
            jsonString = JSON.toJSON(categories).toString();
            log.debug("get category info:"+jsonString);
            return jsonString;
        }
        return jsonString;
    }

}
