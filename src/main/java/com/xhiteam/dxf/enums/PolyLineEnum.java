package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fengwen
 * @version V1.0
 */
@Getter
@AllArgsConstructor
public enum PolyLineEnum {

    /**
     * 多线段名称
     */
    POLYLINE_NAME("POLYLINE", "多线段名称"),

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
    COORDINATE_Z("30", "z坐标"),

    /**
     * 顶点名称
     */
    VERTEX_NAME("VERTEX", "顶点名称"),


    /**
     * 多线段结束
     */
    SEQEND("SEQEND", "多线段结束");

    /**
     * 组码
     */
    private String code;

    /**
     * 组码名称
     */
    private String fieldName;

}
