package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author fengwen
 * @version V1.0
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
