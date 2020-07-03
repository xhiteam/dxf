package com.xhiteam.dxf.transformation.imp;

import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.transformation.DxfLineTransformation;
import com.xhiteam.dxf.transformation.GeometricTransform;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Description 几何线的转换
 * @Author fengwen
 * @Date 2020/1/19 22:58
 * @Version V1.0
 */
public class GeometricLineTransformImpl implements GeometricTransform<GeometricLine> {

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
                    geometricTransform = new GeometricLineTransformImpl();
                }
            }
        }
        return geometricTransform;
    }

    /**
     * 几何线的转换
     *
     * @param objectList 转换的数据
     * @return List<GeometricLine>
     */
    @Override
    public List<GeometricLine> transform(List<GeometricObject> objectList) {
        List<GeometricLine> lineList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(objectList)) {
            for (GeometricObject object : objectList) {
                if (object instanceof GeometricLine) {
                    lineList.add((GeometricLine) object);
                }
            }
        }
        return lineList;
    }
}
