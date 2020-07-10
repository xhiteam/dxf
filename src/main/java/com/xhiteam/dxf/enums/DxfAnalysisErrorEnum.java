package com.xhiteam.dxf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fengwen
 * @version V1.0
 */
@Getter
@AllArgsConstructor
public enum DxfAnalysisErrorEnum {

    /**
     * DXF文件解析未知错误
     */
    FILE_ANALYSIS_UNKNOWN_ERROR("0001", "DXF文件解析未知错误"),

    /**
     * 圆002x
     */
    CIRCLE_NOT_X("0020", "dxf解析圆数据没有获取到圆心x坐标"),
    CIRCLE_NOT_Y("0021", "dxf解析圆数据没有获取到圆心y坐标"),
    CIRCLE_NOT_Z("0022", "dxf解析圆数据没有获取到圆心z坐标"),
    CIRCLE_NOT_RADIUS("0023", "dxf解析圆数据没有获取到半径值"),

    /**
     * 点003x
     */
    POINT_NOT_X("0030", "dxf解析点数据没有获取到点x坐标"),
    POINT_NOT_Y("0031", "dxf解析点数据没有获取到点y坐标"),
    POINT_NOT_Z("0032", "dxf解析点数据没有获取到点z坐标"),

    /**
     * 直线004x
     */
    LINE_START_NOT_X("0040", "dxf解析直线数据没有获取到起点x坐标"),
    LINE_START_NOT_Y("0041", "dxf解析直线数据没有获取到起点y坐标"),
    LINE_START_NOT_Z("0042", "dxf解析直线数据没有获取到起点z坐标"),
    LINE_END_NOT_X("0043", "dxf解析直线数据没有获取到终点x坐标"),
    LINE_END_NOT_Y("0044", "dxf解析直线数据没有获取到终点y坐标"),
    LINE_END_NOT_Z("0045", "dxf解析直线数据没有获取到终点z坐标"),

    /**
     * 弧线005x
     */
    ARC_NOT_X("0050", "dxf解析弧线数据没有获取到圆心x坐标"),
    ARC_NOT_Y("0051", "dxf解析弧线数据没有获取到圆心y坐标"),
    ARC_NOT_Z("0052", "dxf解析弧线数据没有获取到圆心z坐标"),
    ARC_NOT_RADIUS("0053", "dxf解析弧线数据没有获取到半径"),
    ARC_NOT_START_ANGLE("0054", "dxf解析弧线数据没有获取到起始角度"),
    ARC_NOT_END_ANGLE("0055", "dxf解析弧线数据没有获取到中止角度"),


    /**
     * 多线段006x
     */
    POLY_LINE_NOT_COORDINATE_X("0060", "dxf解析多线段时没有获取到顶点x坐标"),
    POLY_LINE_NOT_COORDINATE_Y("0061", "dxf解析多线段时没有获取到顶点y坐标"),
    POLY_LINE_NOT_COORDINATE_Z("0062", "dxf解析多线段时没有获取到顶点z坐标"),
    POLY_LINE_NOT_SEQEND("0063", "dxf解析多线段时没有获取到结束标记");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

}
