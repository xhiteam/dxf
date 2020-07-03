package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 错误码枚举类
 * @Author fengwen
 * @Date 2019/3/29 18:17
 **/
@Getter
@AllArgsConstructor
public enum DxfFileErrorEnum {

    /**
     * DXF文件后缀错误
     */
    DXF_FILE_ERROR("0001", "DXF文件类型错误");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

}
