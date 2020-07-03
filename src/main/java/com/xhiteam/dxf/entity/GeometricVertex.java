package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description dxf多线段顶点
 * @Author youjianzhao
 * @Date 2020/2/13 15:49
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeometricVertex extends GeometricObject {

    private static final long serialVersionUID = 1685606296528470644L;

    /**
     * 顶点的x坐标
     */
    private BigDecimal x;

    /**
     * 顶点的y坐标
     */
    private BigDecimal y;

    /**
     * 顶点的z坐标
     */
    private BigDecimal z;
}
