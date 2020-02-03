package com.sun.provincecenter.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 返回值说明码
 * @author zcm
 */
@Getter
@AllArgsConstructor
public enum  ResultEnums {
    /**
     * 成功
     */
    SUCCESS(200,"success"),
    FAILURE(400,"failure"),
    PARAM_ERROR(201,":参数错误"),
    SEARCH_ERROR(201,"查询参数返回失败"),

    ;

    private Integer code;
    private String message;

}
