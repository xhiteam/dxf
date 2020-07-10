package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author fengwen
 * @version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class GeometricArc extends GeometricObject {

    private static final long serialVersionUID = 8506061767127319973L;

    /**
     * 弧线的半径
     */
    private BigDecimal radius;

    /**
     * 弧的起始角度
     */
    private BigDecimal startArc;

    /**
     * 弧的终止角度
     */
    private BigDecimal endArc;

    /**
     * 弧线圆心的x坐标
     */
    private BigDecimal x;

    /**
     * 弧线圆心的y坐标
     */
    private BigDecimal y;

    /**
     * 弧线圆心的z坐标
     */
    private BigDecimal z;


}
