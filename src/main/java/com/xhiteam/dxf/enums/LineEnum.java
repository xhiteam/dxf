package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fengwen
 * @Description 线的组码枚举
 * @Date 2019/12/10 23:19
 * @Version V1.0
 */
@Getter
@AllArgsConstructor
public enum LineEnum {

    /**
     * 直线名称
     */
    LINE_NAME("LINE", "直线名称"),

    /**
     * 图层名称
     */
    LAYER_NAME("8", "图层名称"),

    /**
     * x坐标
     */
    COORDINATE_X("10", "x坐标"),

    /**
     * 直线终点X坐标
     */
    LINE_END_X_COORDINATES("11","直线终点x的坐标"),

    /**
     * y坐标
     */
    COORDINATE_Y("20", "y坐标"),

    /**
     * 直线终点y坐标
     */
    LINE_END_Y_COORDINATES("21","直线终点y的坐标"),

    /**
     * z坐标
     */
    COORDINATE_Z("30", "z坐标"),

    /**
     * 直线终点z坐标
     */
    LINE_END_Z_COORDINATES("31","直线终点z的坐标");

    /**
     * 组码
     */
    private String code;

    /**
     * 组码名称
     */
    private String fieldName;

}
