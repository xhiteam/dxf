package com.xhiteam.dxf.util;

import com.xhiteam.dxf.constant.EntityNameConstant;
import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.transformation.GeometricTransform;
import com.xhiteam.dxf.transformation.TransformBuilder;

import java.util.List;

/**
 * @author fengwen
 * @version V1.0
 */
public class GeometricTransformUtil {

    /**
     * 转换GeometricObject为GeometricPoint
     *
     * @param objectList 需要转换的GeometricObject数据
     * @return 转换GeometricPoint
     */
    public static List<GeometricPoint> transformGeometricPoint(List<GeometricObject> objectList) {
        GeometricTransform geometricTransform = TransformBuilder.builder(EntityNameConstant.POINT_NAME);
        return geometricTransform.transform(objectList);
    }

    /**
     * 转换GeometricObject为GeometricLine
     *
     * @param objectList 需要转换的GeometricObject数据
     * @return 转换GeometricLine
     */
    public static List<GeometricLine> transformGeometricLine(List<GeometricObject> objectList) {
        GeometricTransform geometricTransform = TransformBuilder.builder(EntityNameConstant.LINE_NAME);
        return geometricTransform.transform(objectList);
    }

    /**
     * 转换GeometricObject为GeometricArc
     *
     * @param objectList 需要转换的GeometricObject数据
     * @return 转换GeometricArc
     */
    public static List<GeometricArc> transformGeometricArc(List<GeometricObject> objectList) {
        GeometricTransform geometricTransform = TransformBuilder.builder(EntityNameConstant.ARC_NAME);
        return geometricTransform.transform(objectList);
    }

    /**
     * 转换GeometricObject为GeometricCircle
     *
     * @param objectList 需要转换的GeometricObject数据
     * @return 转换GeometricCircle
     */
    public static List<GeometricCircle> transformGeometricCircle(List<GeometricObject> objectList) {
        GeometricTransform geometricTransform = TransformBuilder.builder(EntityNameConstant.CIRCLE_NAME);
        return geometricTransform.transform(objectList);
    }


    /**
     * 转换GeometricObject为GeometricPolyLine
     *
     * @param objectList 需要转换的GeometricObject数据
     * @return 转换GeometricPolyLine
     */
    public static List<GeometricPolyLine> transformGeometricPolyLine(List<GeometricObject> objectList) {
        GeometricTransform geometricTransform = TransformBuilder.builder(EntityNameConstant.POLY_LINE_NAME);
        return geometricTransform.transform(objectList);
    }
}
