package com.muses.taoshop.web.controller.portal;

import com.muses.taoshop.item.entity.ItemDetail;
import com.muses.taoshop.item.entity.ItemSpec;
import com.muses.taoshop.item.entity.ItemSpecValue;
import com.muses.taoshop.item.service.IItemService;
import com.muses.taoshop.item.service.IItemSpecService;
import com.muses.taoshop.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
@RequestMapping("/portal/item")
public class ItemDetailController extends BaseController{

    @Autowired
    IItemService iItemService;
    @Autowired
    IItemSpecService iItemSpecService;

    @GetMapping("/toDetail/{spuId}/{skuId}")
    public ModelAndView toDetail(@PathVariable int spuId, @PathVariable int skuId){
        ModelAndView mv = this.getModelAndView();
        ItemDetail itemDetail = iItemService.getItemDetailInfo(spuId);
        List<ItemSpec> itemSpecList = iItemSpecService.getSpecBySpuId(spuId);
        List<ItemSpecValue> itemSpecValueList = iItemSpecService.getSpecValueBySkuId(skuId);
        mv.addObject("itemDetail", itemDetail);
        mv.addObject("itemSpec", itemSpecList);
        mv.addObject("itemSpecValue", itemSpecValueList);
        mv.setViewName("item/item_detail");
        return mv;
    }

}
