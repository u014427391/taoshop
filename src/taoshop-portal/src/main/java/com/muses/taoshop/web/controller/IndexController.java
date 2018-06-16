package com.muses.taoshop.web.controller;

import com.alibaba.fastjson.JSON;
import com.muses.taoshop.item.dto.ItemBrand;
import com.muses.taoshop.item.service.IItemBrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 *  控制类
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
public class IndexController {

    @Autowired
    IItemBrankService iItemBrankService;

    //@RequestMapping(value = "/toIndex" ,method = RequestMethod.GET)
    @GetMapping(value = "/toIndex.do")
    public String toIndex(){
        return "/index";
    }

    public String test(){

        return  "";
    }

    @GetMapping(value = "/doTest")
    @ResponseBody
    public String doTest(){
        List<ItemBrand> itemBrands = iItemBrankService.listItemBrand();
        String str = JSON.toJSON(itemBrands).toString();
        return str;
    }

}
