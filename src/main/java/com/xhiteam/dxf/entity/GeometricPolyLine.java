package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author fengwen
 * @Description dxf几何图形多线段
 * @Date 2019/12/10 23:13
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class GeometricPolyLine extends GeometricObject {

    private static final long serialVersionUID = 8069202425179988523L;


    /**
     * 多个顶点点组成
     */
    private List<GeometricVertex> vertexList;

}
