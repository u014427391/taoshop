package com.muses.taoshop.portal.web.controller;

import com.muses.taoshop.service.IItemBrankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
