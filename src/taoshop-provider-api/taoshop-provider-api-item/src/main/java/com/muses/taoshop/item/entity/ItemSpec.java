package com.muses.taoshop.item.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>
 *  商品规格VO类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.09 21:49    修改内容:
 * </pre>
 */
@Setter
@Getter
@ToString
public class ItemSpec {
    /**
     * id
     */
    private Long id;
    /**
     * 规格编号
     */
    private String specNo;
    /**
     * 规格名称
     */
    private String specName;

    private Date lastModifyTime;

    private Date createTime;


}