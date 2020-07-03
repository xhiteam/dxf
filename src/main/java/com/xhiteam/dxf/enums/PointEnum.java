package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fengwen
 * @Description 点的组码枚举
 * @Date 2019/12/10 23:19
 * @Version V1.0
 */
@Getter
@AllArgsConstructor
public enum PointEnum {

    /**
     * 点名称
     */
    POINT_NAME("POINT", "点名称"),

    /**
     * 图层名称
     */
    LAYER_NAME("8", "图层名称"),

    /**
     * x坐标
     */
    COORDINATE_X("10", "x坐标"),

    /**
     * y坐标
     */
    COORDINATE_Y("20", "y坐标"),

    /**
     * z坐标
     */
    COORDINATE_Z("30", "z坐标");
    /**
     * 组码
     */
    private String code;

    /**
     * 组码名称
     */
    private String fieldName;

}
