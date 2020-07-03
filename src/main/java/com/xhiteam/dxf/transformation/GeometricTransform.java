package com.xhiteam.dxf.transformation;

import com.xhiteam.dxf.entity.GeometricObject;

import java.util.List;

/**
 * @Description 几何图形转换
 * @Author fengwen
 * @Date 2020/1/19 22:53
 * @Version V1.0
 */
public interface GeometricTransform<T> {

    /**
     * 将GeometricObject转换为GeometricLine
     *
     * @param objectList 转换的数据
     * @return List<GeometricLine>
     */
    List<T> transform(List<GeometricObject> objectList);

}
