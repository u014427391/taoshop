package com.muses.taoshop.portal.web.controller;

import com.muses.taoshop.service.IItemBrankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    //@RequestMapping(value = "/toIndex" ,method = RequestMethod.GET)
    @GetMapping(value = "/toIndex.do")
    public String toIndex(){
        return "/index";
    }

    public String test(){

        return  "";
    }

}
