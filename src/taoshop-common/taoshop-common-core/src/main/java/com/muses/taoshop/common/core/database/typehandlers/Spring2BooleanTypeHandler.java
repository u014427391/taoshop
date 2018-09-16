package com.muses.taoshop.common.core.database.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 *  将数据库中的"Y"和"N"类型转为boolean类型
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:2018.05.26     修改内容:
 * </pre>
 */
public class Spring2BooleanTypeHandler implements TypeHandler<Object>{


    /**
     *
     *(non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {

    }

    /**
     * (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        boolean flag ;
        if(resultSet.getString(s).equals("Y")){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    /**
     *
     *(non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        boolean flag;
        if(resultSet.getString(i).equals("Y")){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    /**
     * (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }

}
