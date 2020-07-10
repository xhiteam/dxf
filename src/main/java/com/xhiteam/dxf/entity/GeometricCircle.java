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
public class GeometricCircle extends GeometricObject {

    private static final long serialVersionUID = 4113928189278002895L;

    /**
     * 圆心的半径
     */
    private BigDecimal radius;

    /**
     * 圆心的x坐标
     */
    private BigDecimal x;

    /**
     * 圆心的y坐标
     */
    private BigDecimal y;

    /**
     * 圆心的z坐标
     */
    private BigDecimal z;

}
