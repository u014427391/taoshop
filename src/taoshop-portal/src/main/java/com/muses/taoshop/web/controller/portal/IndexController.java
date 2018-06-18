package com.muses.taoshop.web.controller.portal;

import com.alibaba.fastjson.JSON;
import com.muses.taoshop.item.entity.ItemBrand;
import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.service.IItemBrankService;
import com.muses.taoshop.item.service.IItemCategoryService;
import com.muses.taoshop.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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
    IItemBrankService iItemBrankService;
    @Autowired
    IItemCategoryService iItemCategoryService;

    //@RequestMapping(value = "/toIndex" ,method = RequestMethod.GET)

    /**
     * 跳转到门户网站
     * @return
     */
    @GetMapping(value = "/toIndex.do")
    public String toIndex(){
        return "/index";
    }

    @GetMapping(value = "/doTest")
    @ResponseBody
    public  String doTest(){
        List<ItemBrand> itemBrands = iItemBrankService.listItemBrand();
        String str = JSON.toJSON(itemBrands).toString();
        return str;
    }

    @GetMapping(value = "/listRootCategory")
    @ResponseBody
    public String listRootCategory(){
        List<ItemCategory> categories = iItemCategoryService.listCategory();
        for(ItemCategory itemCategory : categories){
            Date unixlongTime = itemCategory.getCreateTime();
            log.debug("create time!!!!!!!!!"+unixlongTime);
        }
        String jsonString = "";
        if(!CollectionUtils.isEmpty(categories)){
            jsonString = JSON.toJSON(categories).toString();
            log.debug("get root category info:"+jsonString);
            return jsonString;
        }
        return jsonString;
    }

}
