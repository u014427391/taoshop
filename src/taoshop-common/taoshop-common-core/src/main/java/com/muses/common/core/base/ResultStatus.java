package com.muses.common.core.base;

/**
 * <pre>
 *  返回结果枚举类 TODO 代补充完善
 * </pre>
 *
 * @author nicky.ma
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public enum ResultStatus {

    //TODO add result status
    OK("200","OK","成功"),
    VALIDATION_ERROR("400","Validation Error","参数校验异常"),
    AUTHENTICATION_ERROR("300","Authentication Error","身份认证异常");

    private final String statusCode;

    private final String resonPhrase;

    private final String message;

    private ResultStatus(String statusCode, String resonPhrase, String message) {
        this.statusCode = statusCode;
        this.resonPhrase = resonPhrase;
        this.message = message;
    }
}
