package com.xhiteam.dxf.transformation;

import com.xhiteam.dxf.continuity.DxfLine;
import com.xhiteam.dxf.entity.GeometricObject;

import java.util.List;

/**
 * @author fengwen
 * @version V1.0
 */
public interface DxfLineTransformation {


    /**
     * 将几何点转换为几何线
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> pointTransform(List<GeometricObject> list);

    /**
     * 将几何圆、转换为点圆数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> circleTransform(List<GeometricObject> list);


    /**
     * 将几何弧线、转换为点弧线数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> arcTransform(List<GeometricObject> list);


    /**
     * 将几何椭圆、转换为点椭圆数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> ellipseTransform(List<GeometricObject> list);

    /**
     * 将几何线、转换为点线数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> lineTransform(List<GeometricObject> list);

    /**
     * 将几何多线段、转换为点多线段数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    List<DxfLine> polyLineTransform(List<GeometricObject> list);


}
