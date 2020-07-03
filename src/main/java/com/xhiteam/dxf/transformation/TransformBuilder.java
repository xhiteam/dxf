package com.xhiteam.dxf.transformation;

import com.xhiteam.dxf.constant.EntityNameConstant;
import com.xhiteam.dxf.transformation.imp.GeometricArcTransformImpl;
import com.xhiteam.dxf.transformation.imp.GeometricCircleTransformImpl;
import com.xhiteam.dxf.transformation.imp.GeometricLineTransformImpl;
import com.xhiteam.dxf.transformation.imp.GeometricPointTransformImpl;
import com.xhiteam.dxf.transformation.imp.GeometricPolyLineTransformImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 转换类创建构建者
 * @Author fengwen
 * @Date 2020/1/19 23:27
 * @Version V1.0
 */
public class TransformBuilder {

    /**
     * 容器
     */
    private Map<String, GeometricTransform> map;

    public TransformBuilder() {
        map = new HashMap<>();
        map.put(EntityNameConstant.ARC_NAME, GeometricArcTransformImpl.getSingleInstance());
        map.put(EntityNameConstant.CIRCLE_NAME, GeometricCircleTransformImpl.getSingleInstance());
        map.put(EntityNameConstant.LINE_NAME, GeometricLineTransformImpl.getSingleInstance());
        map.put(EntityNameConstant.POINT_NAME, GeometricPointTransformImpl.getSingleInstance());
        map.put(EntityNameConstant.POLY_LINE_NAME, GeometricPolyLineTransformImpl.getSingleInstance());
    }

    /**
     * 静态内部类
     */
    public static class Holder {
        public static TransformBuilder transformBuilder = new TransformBuilder();
    }

    /**
     * 构建方法
     *
     * @param type 类型
     * @return GeometricTransform
     */
    public static GeometricTransform builder(String type) {
        return Holder.transformBuilder.map.get(type);
    }

}
