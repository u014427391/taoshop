package com.muses.taoshop.util;

import com.muses.taoshop.item.entity.ItemCategory;

import javax.mail.FetchProfile;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  构造一棵品类树
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.24 17:12    修改内容:
 * </pre>
 */
public class CategoryTreeUtil {


    public List<ItemCategory> commonCategorys;

    public List<ItemCategory> list = new ArrayList<ItemCategory>();

    public List<ItemCategory> buildCategoryTree(List<ItemCategory> categories ) {
        this.commonCategorys = categories;
        for (ItemCategory c : categories){
            ItemCategory category = new ItemCategory();
            if(c.getSjid() == 0){
                category.setSjid(c.getSjid());
                category.setId(c.getId());
                category.setCategoryName(c.getCategoryName());
                category.setSubCategorys(treeChild(c.getId()));
                list.add(category);
            }
        }
        return list;
    }

    public List<ItemCategory> treeChild(long id){
        List<ItemCategory> list = new ArrayList<ItemCategory>();
        for(ItemCategory c : commonCategorys){
            ItemCategory category = new ItemCategory();
            if(c.getSjid() == id){
                category.setSjid(c.getSjid());
                category.setId(c.getId());
                category.setCategoryName(c.getCategoryName());
                category.setSubCategorys(treeChild(c.getId()));//递归循环
                list.add(category);
            }
        }
        return list;
    }
}
