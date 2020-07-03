package com.xhiteam.dxf.collector;

import com.xhiteam.dxf.continuity.DxfLine;
import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.entity.GeometricPolyLine;

import java.util.List;
import java.util.Map;

/**
 * @Description DXF数据采集者
 * @Author fengwen
 * @Date 2019/12/22 16:34
 * @Version V1.0
 */
public interface DxfCollector {

    /**
     * 获取dxf几何数据（初步）
     *
     * @return 返回map数据
     */
    Map<String, List<GeometricObject>> getMap();

    /**
     * 获取点线数据list，这种数据类型是符合rtas项目中使用的
     *
     * @return 点线数据
     */
    List<DxfLine> getDxfLineList();


    /**
     * 获取dxf文件中所有的几何点
     *
     * @return 所有的几何点
     */
    List<GeometricPoint> getGeometricPointList();

    /**
     * 获取dxf文件中所有的几何线
     *
     * @return 所有的几何线
     */
    List<GeometricLine> getGeometricLineList();


    /**
     * 获取dxf文件中所有的几何弧线
     *
     * @return 所有的几何弧线
     */
    List<GeometricArc> getGeometricArcList();


    /**
     * 获取dxf文件中所有的几何圆
     *
     * @return 所有的几何圆
     */
    List<GeometricCircle> getGeometricCircleList();

    /**
     * 获取dxf文件中所有的几何多线段
     *
     * @return 所有的几何多线段
     */
    List<GeometricPolyLine> getGeometricPolyLineList();

}