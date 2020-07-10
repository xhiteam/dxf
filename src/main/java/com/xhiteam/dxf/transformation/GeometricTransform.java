package com.xhiteam.dxf.transformation;

import com.xhiteam.dxf.entity.GeometricObject;

import java.util.List;

/**
 * @author fengwen
 * @version V1.0
 */
public interface GeometricTransform<T> {

    /**
     * 将GeometricObject转换为GeometricLine
     *
     * @param objectList 转换的数据
     * @return List
     */
    List<T> transform(List<GeometricObject> objectList);

}
