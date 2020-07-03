package com.xhiteam.dxf.transformation.imp;

import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.transformation.DxfLineTransformation;
import com.xhiteam.dxf.transformation.GeometricTransform;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Description 几何多线段转换
 * @Author fengwen
 * @Date 2020/1/19 22:59
 * @Version V1.0
 */
public class GeometricPolyLineTransformImpl implements GeometricTransform<GeometricPolyLine> {

    /**
     * 实例对象
     */
    private static GeometricTransform geometricTransform;

    /**
     * 采用单例模式
     *
     * @return
     */
    public static GeometricTransform getSingleInstance() {
        if (geometricTransform == null) {
            synchronized (DxfLineTransformation.class) {
                if (geometricTransform == null) {
                    geometricTransform = new GeometricPolyLineTransformImpl();
                }
            }
        }
        return geometricTransform;
    }

    /**
     * 几何多线段转换
     *
     * @param objectList 转换的数据
     * @return List<GeometricPolyLine>
     */
    @Override
    public List<GeometricPolyLine> transform(List<GeometricObject> objectList) {
        List<GeometricPolyLine> polyLineList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(objectList)) {
            for (GeometricObject object : objectList) {
                if (object instanceof GeometricPolyLine) {
                    polyLineList.add((GeometricPolyLine) object);
                }
            }
        }
        return polyLineList;
    }
}
