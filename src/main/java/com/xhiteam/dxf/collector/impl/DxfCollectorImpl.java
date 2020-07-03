package com.xhiteam.dxf.collector.impl;

import com.xhiteam.dxf.analysis.DxfAnalysis;
import com.xhiteam.dxf.collector.DxfCollector;
import com.xhiteam.dxf.continuity.DxfLine;
import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.enums.ArcEnum;
import com.xhiteam.dxf.enums.CircleEnum;
import com.xhiteam.dxf.enums.LineEnum;
import com.xhiteam.dxf.enums.PointEnum;
import com.xhiteam.dxf.util.GeometricTransformUtil;
import com.xhiteam.dxf.util.DxfLineTransformUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * @Description DXF数据采集者实现
 * @Author fengwen
 * @Date 2019/12/22 10:14
 * @Version V1.0
 */
public class DxfCollectorImpl implements DxfCollector {

    /**
     * dxf文件
     */
    private File file;

    /**
     * 初步解析的数据
     */
    private Map<String, List<GeometricObject>> baseMap;

    /**
     * 构造方法
     *
     * @param file dxf文件
     * @throws IOException IO异常
     */
    public DxfCollectorImpl(File file) throws IOException {
        this.file = file;
        baseMap = getBaseMap();
    }

    /**
     * 获取dxf几何数据（初步）
     * map的key: 几何图像名称，比如：‘POINT’
     * map的value:几何图像集合，比如：List<GeometricObject>
     *
     * @return 返回map数据
     */
    @Override
    public Map<String, List<GeometricObject>> getMap() {
        return baseMap;
    }

    /**
     * 获取点线数据list，这种数据类型是符合rtas项目中使用的
     *
     * @return 点线数据
     */
    @Override
    public List<DxfLine> getDxfLineList() {
        //几何数据转换点线数据
        return DxfLineTransformUtil.geometricTransform(baseMap);
    }


    /**
     * 获取dxf文件中所有的几何点
     *
     * @return 返回几何点集合
     */
    @Override
    public List<GeometricPoint> getGeometricPointList() {
        //从map中把所有的GeometricPoint拿出来
        List<GeometricObject> objectList = baseMap.get(PointEnum.POINT_NAME.getCode());
        //把GeometricPoint转换为GeometricPoint
        return GeometricTransformUtil.transformGeometricPoint(objectList);
    }

    /**
     * 获取dxf文件中所有的几何线
     *
     * @return 返回几何线集合
     */
    @Override
    public List<GeometricLine> getGeometricLineList() {
        //从map中把所有的GeometricLine拿出来
        List<GeometricObject> objectList = baseMap.get(LineEnum.LINE_NAME.getCode());
        //把GeometricPoint转换为GeometricLine
        return GeometricTransformUtil.transformGeometricLine(objectList);
    }


    /**
     * 获取dxf文件中所有的几何弧线
     *
     * @return 返回几何弧线集合
     */
    @Override
    public List<GeometricArc> getGeometricArcList() {
        //从map中把所有的GeometricArc拿出来
        List<GeometricObject> objectList = baseMap.get(ArcEnum.ARC_NAME.getCode());
        //把GeometricPoint转换为GeometricArc
        return GeometricTransformUtil.transformGeometricArc(objectList);
    }

    /**
     * 获取dxf文件中所有的几何圆
     *
     * @return 返回几何圆集合
     */
    @Override
    public List<GeometricCircle> getGeometricCircleList() {
        //从map中把所有的GeometricCircle拿出来
        List<GeometricObject> objectList = baseMap.get(CircleEnum.CIRCLE_NAME.getCode());
        //把GeometricPoint转换为GeometricCircle
        return GeometricTransformUtil.transformGeometricCircle(objectList);
    }

    /**
     * 获取dxf文件中所有的几何多线段
     *
     * @return 返回几何多线段集合
     */
    @Override
    public List<GeometricPolyLine> getGeometricPolyLineList() {
        //从map中把所有的GeometricPolyLine拿出来
        List<GeometricObject> objectList = baseMap.get(CircleEnum.CIRCLE_NAME.getCode());
        //把GeometricPoint转换为GeometricPolyLine
        return GeometricTransformUtil.transformGeometricPolyLine(objectList);
    }


    /**
     * 获取原始数据map
     *
     * @return 返回map数据
     * @throws IOException 文件IO异常
     */
    private Map<String, List<GeometricObject>> getBaseMap() throws IOException {
        // 包装文件流
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //读取文件获取数据，返回map
        Map<String, List<GeometricObject>> map = DxfAnalysis.getGeometricListMap(reader);

        //关闭文件流
        if (inputStream != null) {
            inputStream.close();
        }
        if (reader != null) {
            reader.close();
        }
        return map;
    }

}
