package com.sun.provincecenter.exception;

import com.sun.provincecenter.enums.ResultEnums;

/**
 * 异常
 * @author zcm
 */
public class ProvinceException extends RuntimeException{

    private Integer code;

    public ProvinceException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProvinceException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }
}
