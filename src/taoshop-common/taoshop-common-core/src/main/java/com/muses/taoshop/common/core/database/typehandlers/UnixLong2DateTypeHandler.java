package com.muses.taoshop.common.core.database.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *  TODO 类说明
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.18 14:04    修改内容:
 * </pre>
 */
public class UnixLong2DateTypeHandler implements TypeHandler<Date> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date o, JdbcType jdbcType) throws SQLException {
    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        long unixlongTime = resultSet.getLong(s);
        Date date = new Date(unixlongTime*1000);
        return date;
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        long unixlongTime = resultSet.getLong(i);
        Date date = new Date(unixlongTime*1000);
        return date;
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
