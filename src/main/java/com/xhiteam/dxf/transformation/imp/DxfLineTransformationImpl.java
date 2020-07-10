package com.xhiteam.dxf.transformation.imp;

import com.xhiteam.dxf.continuity.DxfLine;
import com.xhiteam.dxf.continuity.DxfPoint;
import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricVertex;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.transformation.DxfLineTransformation;
import com.xhiteam.dxf.util.GeometricTransformUtil;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author fengwen
 * @version V1.0
 */
public class DxfLineTransformationImpl implements DxfLineTransformation {

    /**
     * 实例对象
     */
    private static DxfLineTransformation dxfLineTransformation;

    /**
     * 采用单例模式
     *
     * @return DxfLineTransformation
     */
    public static DxfLineTransformation getSingleInstance() {
        if (dxfLineTransformation == null) {
            synchronized (DxfLineTransformation.class) {
                if (dxfLineTransformation == null) {
                    dxfLineTransformation = new DxfLineTransformationImpl();
                }
            }
        }
        return dxfLineTransformation;
    }

    /**
     * 将几何点转换为几何线
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> pointTransform(List<GeometricObject> list) {

        List<GeometricPoint> geometricPointList = GeometricTransformUtil.transformGeometricPoint(list);

        List<DxfLine> dxfLineList = Lists.newArrayList();

        for (GeometricPoint point : geometricPointList) {
            DxfLine dxfLine = new DxfLine();
            dxfLine.setLayerName(point.getGeometricName());
            DxfPoint startPoint = new DxfPoint(1L, point);
            DxfPoint endPoint = new DxfPoint(2L, point);
            List<DxfPoint> dxfPoints = Lists.newArrayList();
            dxfPoints.add(startPoint);
            dxfPoints.add(endPoint);
            dxfLine.setDataPointList(dxfPoints);
            dxfLineList.add(dxfLine);
        }
        return dxfLineList;
    }

    /**
     * 将几何圆、转换为点圆数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> circleTransform(List<GeometricObject> list) {


        List<GeometricCircle> geometricCircleList = GeometricTransformUtil.transformGeometricCircle(list);


        List<DxfLine> dxfLineList = Lists.newArrayList();

        for (GeometricCircle geometricCircle : geometricCircleList) {

            DxfLine dxfLine = new DxfLine();
            dxfLine.setLayerName(geometricCircle.getGeometricName());

            Double radius = 2.0;
            Double end = 360.0;

            //编号从第二个点开始
            Long num = 2L;

            //圆心x
            Double x = geometricCircle.getX().doubleValue();
            //圆心y
            Double y = geometricCircle.getY().doubleValue();
            //圆心z
            Double z = geometricCircle.getZ().doubleValue();
            //半径
            Double r = geometricCircle.getRadius().doubleValue();
            //点集
            List<DxfPoint> dxfPoints = Lists.newArrayList();
            //原点，编号为0
            DxfPoint originPoint = new DxfPoint(0L, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
            //起点
            DxfPoint startPoint = new DxfPoint(1L, BigDecimal.valueOf(x + r), BigDecimal.valueOf(y), BigDecimal.valueOf(z));
            dxfPoints.add(originPoint);
            dxfPoints.add(startPoint);
            while (radius < end) {
                Double arc = (Math.PI / 180) * radius;
                Double x1 = x + r * (Math.cos(arc));
                Double y1 = y + r * (Math.sin(arc));
                DxfPoint endPoint = new DxfPoint(num, BigDecimal.valueOf(x1), BigDecimal.valueOf(y1), BigDecimal.valueOf(z));
                num = num + 1L;
                dxfPoints.add(endPoint);
                radius = radius + 2.0;
            }
            dxfLine.setDataPointList(dxfPoints);
            dxfLineList.add(dxfLine);
        }

        return dxfLineList;
    }

    /**
     * 将几何弧线、转换为点弧线数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> arcTransform(List<GeometricObject> list) {

        List<GeometricArc> geometricArcList = GeometricTransformUtil.transformGeometricArc(list);


        List<DxfLine> dxfLineList = Lists.newArrayList();

        for (GeometricArc geometricArc : geometricArcList) {
            DxfLine dxfLine = new DxfLine();
            dxfLine.setLayerName(geometricArc.getGeometricName());
            Double strat = geometricArc.getStartArc().doubleValue();
            Double end = geometricArc.getEndArc().doubleValue();
            if (strat > end) {
                end = end + 360;
            }

            //编号从第一个点开始
            Long num = 1L;
            //圆心x
            Double x = geometricArc.getX().doubleValue();
            //圆心y
            Double y = geometricArc.getY().doubleValue();
            //圆心z
            Double z = geometricArc.getZ().doubleValue();
            //半径
            Double r = geometricArc.getRadius().doubleValue();
            //点集
            List<DxfPoint> dxfPoints = Lists.newArrayList();
            Double radius = strat;

            //原点,编号为0
            DxfPoint originPoint = new DxfPoint(0L, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
            dxfPoints.add(originPoint);

            while (radius < end) {
                Double arc = (Math.PI / 180) * radius;
                Double x1 = x + r * (Math.cos(arc));
                Double y1 = y + r * (Math.sin(arc));
                DxfPoint point2 = new DxfPoint(num, BigDecimal.valueOf(x1), BigDecimal.valueOf(y1), BigDecimal.valueOf(z));
                dxfPoints.add(point2);
                radius = radius + 1;
                num = num + 1L;
            }
            if (radius >= end) {
                radius = radius - 1;
                radius = radius + (end - radius);
                Double arc2 = (Math.PI / 180) * radius;
                Double x2 = x + r * (Math.cos(arc2));
                Double y2 = y + r * (Math.sin(arc2));
                DxfPoint point3 = new DxfPoint(num, BigDecimal.valueOf(x2), BigDecimal.valueOf(y2), BigDecimal.valueOf(z));
                dxfPoints.add(point3);
                num = num + 1L;
            }
            dxfLine.setDataPointList(dxfPoints);
            dxfLineList.add(dxfLine);
        }

        return dxfLineList;
    }

    /**
     * 将几何椭圆、转换为点椭圆数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> ellipseTransform(List<GeometricObject> list) {
        return null;
    }

    /**
     * 将几何线、转换为点线数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> lineTransform(List<GeometricObject> list) {

        List<GeometricLine> geometricLineList = GeometricTransformUtil.transformGeometricLine(list);


        List<DxfLine> dxfLineList = Lists.newArrayList();

        for (GeometricLine geometricLine : geometricLineList) {
            DxfLine dxfLine = new DxfLine();
            dxfLine.setLayerName(geometricLine.getGeometricName());
            //点集
            List<DxfPoint> dxfPoints = Lists.newArrayList();
            //原点,编号为0
            DxfPoint originPoint = new DxfPoint(0L, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
            //起点,编号为1
            DxfPoint startPoint = new DxfPoint(1L, geometricLine.getStartX(), geometricLine.getStartY(), geometricLine.getStartZ());
            //终点，编号为2
            DxfPoint endPoint = new DxfPoint(2L, geometricLine.getEndX(), geometricLine.getEndY(), geometricLine.getEndZ());

            dxfPoints.add(originPoint);
            dxfPoints.add(startPoint);
            dxfPoints.add(endPoint);
            dxfLine.setDataPointList(dxfPoints);
            dxfLineList.add(dxfLine);
        }

        return dxfLineList;
    }

    /**
     * 将几何多线段、转换为点多线段数据
     *
     * @param list 需要转换的数据
     * @return 返回点线数据
     */
    @Override
    public List<DxfLine> polyLineTransform(List<GeometricObject> list) {

        List<GeometricPolyLine> geometricPolyLineList = GeometricTransformUtil.transformGeometricPolyLine(list);

        List<DxfLine> dxfLineList = Lists.newArrayList();

        for (GeometricPolyLine geometricPolyLine : geometricPolyLineList) {
            DxfLine dxfLine = new DxfLine();
            dxfLine.setLayerName(geometricPolyLine.getGeometricName());
            //点集
            List<DxfPoint> dxfPoints = Lists.newArrayList();
            //原点,编号为0
            DxfPoint originPoint = new DxfPoint(0L, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
            dxfPoints.add(originPoint);

            //获取顶点集合
            List<GeometricVertex> vertices = geometricPolyLine.getVertexList();
            //顶点编号
            Long number = 1L;

            for (GeometricVertex geometricVertex : vertices) {
                //解析顶点
                DxfPoint vertex = new DxfPoint(number, geometricVertex.getX(), geometricVertex.getY(), geometricVertex.getZ());
                number = number + 1L;
                dxfPoints.add(vertex);
            }
            dxfLine.setDataPointList(dxfPoints);
            dxfLineList.add(dxfLine);
        }

        return dxfLineList;
    }
}
