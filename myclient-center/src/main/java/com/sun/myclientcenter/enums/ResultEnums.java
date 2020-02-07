package com.sun.myclientcenter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回值说明码
 * @author zcm
 */
@Getter
@AllArgsConstructor
public enum ResultEnums {
    /**
     * 成功
     */
    SUCCESS(200,"success"),
    FAILURE(400,"failure"),

    ;

    private Integer code;
    private String message;

}
