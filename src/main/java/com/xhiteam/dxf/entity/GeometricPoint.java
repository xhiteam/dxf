package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author fengwen
 * @Description dxf几何图形点
 * @Date 2019/12/10 23:13
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class GeometricPoint extends GeometricObject {

    private static final long serialVersionUID = -3452451466194147777L;
    /**
     * 点的x坐标
     */
    private BigDecimal x;

    /**
     * 点的y坐标
     */
    private BigDecimal y;

    /**
     * 点的z坐标
     */
    private BigDecimal z;

}
