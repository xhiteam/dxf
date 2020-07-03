package com.xhiteam.dxf.transformation.imp;

import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.transformation.DxfLineTransformation;
import com.xhiteam.dxf.transformation.GeometricTransform;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Description 几何点的转换
 * @Author fengwen
 * @Date 2020/1/19 22:57
 * @Version V1.0
 */
public class GeometricPointTransformImpl implements GeometricTransform<GeometricPoint> {

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
                    geometricTransform = new GeometricPointTransformImpl();
                }
            }
        }
        return geometricTransform;
    }

    /**
     * 几何点的转换
     *
     * @param objectList 转换的数据
     * @return List<GeometricPoint>
     */
    @Override
    public List<GeometricPoint> transform(List<GeometricObject> objectList) {
        List<GeometricPoint> pointList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(objectList)) {
            for (GeometricObject object : objectList) {
                if (object instanceof GeometricPoint) {
                    pointList.add((GeometricPoint) object);
                }
            }
        }
        return pointList;
    }
}
