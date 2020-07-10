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
public class GeometricLine extends GeometricObject {

    private static final long serialVersionUID = -4201197596608609149L;


    /**
     * 线的起点x坐标
     */
    private BigDecimal startX;

    /**
     * 线的起点y坐标
     */
    private BigDecimal startY;

    /**
     * 线的起点z坐标
     */
    private BigDecimal startZ;

    /**
     * 线的终点x坐标
     */
    private BigDecimal endX;

    /**
     * 线的终点y坐标
     */
    private BigDecimal endY;

    /**
     * 线的终点z坐标
     */
    private BigDecimal endZ;


    /**
     * 通过两个点来生成线的构造函数
     * @param p1 点1
     * @param p2 点2
     */
    public GeometricLine(GeometricPoint p1,GeometricPoint p2) {
        this.startX = p1.getX();
        this.startY = p1.getY();
        this.startZ = p1.getZ();
        this.endX = p2.getX();
        this.endY = p2.getY();
        this.endZ = p2.getZ();
    }

}
