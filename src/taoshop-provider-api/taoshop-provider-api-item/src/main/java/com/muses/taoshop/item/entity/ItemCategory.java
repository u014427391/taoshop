package com.muses.taoshop.item.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *  商品品类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.09 21:49    修改内容:
 * </pre>
 */
@Data
public class ItemCategory {
    /**
     * 商品品类id
     */
    private Long id;

    /**
     * 商品品类名称
     */
    private String categoryName;

    /**
     * 上级id
     */
    private Long sjid;

    /**
     * 上次修改时间
     */
    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;

    /**
     * 创建时间
     */
    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 子菜单
     */
    private List<ItemCategory> subCategorys;


}