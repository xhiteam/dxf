package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fengwen
 * @version V1.0
 */
@Getter
@AllArgsConstructor
public enum EllipseEnum {

    /**
     * 椭圆名称
     */
    ELLIPSE_NAME("ELLIPSE", "椭圆名称"),

    /**
     * 图层名称
     */
    LAYER_NAME("8", "图层名称"),

    /**
     * 椭圆圆心X坐标
     */
    COORDINATES_X("10", "X坐标组码"),

    /**
     * 椭圆圆心Y坐标
     */
    COORDINATES_Y("20", "椭圆圆心Y坐标"),

    /**
     * 椭圆圆心Z坐标组码
     */
    COORDINATES_Z("30", "椭圆圆心Z坐标组码"),

    /**
     * 椭圆长轴的端点x
     */
    ELLIPSE_LONG_AXIS_X("11", "椭圆长轴的端点x"),

    /**
     * 椭圆长轴的端点Y
     */
    ELLIPSE_LONG_AXIS_Y("21", "椭圆长轴的端点Y"),

    /**
     * 椭圆长轴的端点Z
     */
    ELLIPSE_LONG_AXIS_Z("31", "椭圆长轴的端点Z"),

    /**
     * 椭圆长轴与短轴的比例
     */
    ELLIPSE_RATIC_LONG_SHOW("40", "椭圆长轴与短轴的比例"),

    /**
     * 椭圆起始参数
     */
    ELLIPSE_START_PARAM("41", "椭圆起始参数"),

    /**
     * 椭圆结束参数
     */
    ELLIPSE_END_PARAM("42", "椭圆结束参数");


    /**
     * 组码
     */
    private String code;

    /**
     * 组码名称
     */
    private String fieldName;


}
