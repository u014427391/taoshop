package com.muses.taoshop.common.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *  日期处理工具类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.18 14:28    修改内容:
 * </pre>
 */
public class DateUtils {


    public static Date doParse(String date){
        DateFormat dateFormat = new SimpleDateFormat();
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
