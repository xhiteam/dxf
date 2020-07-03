package com.xhiteam.dxf.analysis;

import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricLine;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricVertex;
import com.xhiteam.dxf.entity.GeometricPoint;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.enums.ArcEnum;
import com.xhiteam.dxf.enums.CircleEnum;
import com.xhiteam.dxf.enums.DxfAnalysisErrorEnum;
import com.xhiteam.dxf.enums.EllipseEnum;
import com.xhiteam.dxf.enums.FileStructEnum;
import com.xhiteam.dxf.enums.LineEnum;
import com.xhiteam.dxf.enums.PointEnum;
import com.xhiteam.dxf.enums.PolyLineEnum;
import com.xhiteam.dxf.exception.DxfAnalysisException;
import com.xhiteam.dxf.util.DecimalCheckUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengwen
 * @Description dxf解析实现类
 * @Date 2019/12/10 23:38
 * @Version V1.0
 */
public class DxfAnalysis {


    /**
     * 返回几何图像解析数据
     *
     * @param reader BufferedReader
     * @return 解析的数据
     * @throws IOException IO异常
     */
    public static Map<String, List<GeometricObject>> getGeometricListMap(BufferedReader reader) throws IOException {
        Map<String, List<GeometricObject>> map = new HashMap<>();
        //读取dxf所有的数据
        List<String> lineList = readAllLine(reader);
        parseFile(lineList, map);
        return map;
    }

    /**
     * 解析dxf文件结构
     *
     * @param lineList 总数据
     * @param map      接收解析的数据map
     */
    private static void parseFile(List<String> lineList, Map<String, List<GeometricObject>> map) {
        if (CollectionUtils.isEmpty(lineList)) {
            return;
        }
        int i = 0;
        String str = lineList.get(i);
        //未到文件结束标志
        while (!FileStructEnum.FILE_END.getCode().equals(str)) {
            str = lineList.get(++i);
            //实体段开始
            if (FileStructEnum.ENTITIES_START.getCode().equals(str)) {
                //解析实体
                parseEntities(i, lineList, map);
            }
            // 文件循环语句结束
        }
        // 解析函数结束
    }

    /**
     * 解析实体
     *
     * @param i        实体开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     */
    private static void parseEntities(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        while (true) {
            str = lineList.get(++i);

            //点开始
            if (PointEnum.POINT_NAME.getCode().equals(str)) {
                i = getPoint(i, lineList, map);
            }

            //圆开始
            if (CircleEnum.CIRCLE_NAME.getCode().equals(str)) {
                i = getCircle(i, lineList, map);
            }

            // 椭圆开始
            if (EllipseEnum.ELLIPSE_NAME.getCode().equals(str)) {
                // TODO 解析椭圆
            }

            //ARC实体开始
            if (ArcEnum.ARC_NAME.getCode().equals(str)) {
                i = getArc(i, lineList, map);
            }

            //直线开始
            if (LineEnum.LINE_NAME.getCode().equals(str)) {
                i = getLine(i, lineList, map);
            }

            // 多线段
            if (PolyLineEnum.POLYLINE_NAME.getCode().equals(str)) {
                i = getPolyLine(i, lineList, map);
            }

            //实体结束
            if (FileStructEnum.END_SEC.getCode().equals(str)) {
                break;
            }
        }
        // 实体段结束
    }

    /**
     * 解析点
     *
     * @param i        点开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     * @return 返回点读完的最后行数
     */
    private static int getPoint(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        GeometricPoint point = new GeometricPoint();
        while (true) {
            str = lineList.get(++i);
            if (PointEnum.LAYER_NAME.getCode().equals(str)) {
                str = lineList.get(++i);
                point.setGeometricName(str);
            }
            if (PointEnum.COORDINATE_X.getCode().equals(str)) {
                str = lineList.get(++i);
                point.setX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POINT_NOT_X);
                }
            }
            if (PointEnum.COORDINATE_Y.getCode().equals(str)) {
                str = lineList.get(++i);
                point.setY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POINT_NOT_Y);
                }
            }
            if (PointEnum.COORDINATE_Z.getCode().equals(str)) {
                str = lineList.get(++i);
                point.setZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POINT_NOT_Z);
                }
                break;
            }
        }
        List<GeometricObject> pointList = map.get(PointEnum.POINT_NAME.getCode());
        if (pointList == null) {
            pointList = Lists.newArrayList();
        }
        pointList.add(point);
        map.put(PointEnum.POINT_NAME.getCode(), pointList);
        return i;
    }


    /**
     * 获取圆
     *
     * @param i        圆开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     * @return 返回圆读完的最后行数
     */
    private static int getCircle(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        GeometricCircle circle = new GeometricCircle();
        while (true) {
            str = lineList.get(++i);
            //图层名
            if (CircleEnum.LAYER_NAME.getCode().equals(str)) {
                str = lineList.get(++i);
                circle.setGeometricName(str);
            }
            //圆心的x坐标
            if (CircleEnum.COORDINATE_X.getCode().equals(str)) {
                str = lineList.get(++i);
                circle.setX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.CIRCLE_NOT_X);
                }
            }
            //圆心的y坐标
            if (CircleEnum.COORDINATE_Y.getCode().equals(str)) {
                str = lineList.get(++i);
                circle.setY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.CIRCLE_NOT_Y);
                }
            }
            //圆心的z坐标
            if (CircleEnum.COORDINATE_Z.getCode().equals(str)) {
                str = lineList.get(++i);
                circle.setZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.CIRCLE_NOT_Z);
                }
            }
            //解析圆的半径
            if (CircleEnum.CIRCULAR_RADIUS.getCode().equals(str)) {
                str = lineList.get(++i);
                circle.setRadius(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.CIRCLE_NOT_RADIUS);
                }
                break;
            }
        }
        List<GeometricObject> circleList = map.get(CircleEnum.CIRCLE_NAME.getCode());
        if (circleList == null) {
            circleList = Lists.newArrayList();
        }
        circleList.add(circle);
        map.put(CircleEnum.CIRCLE_NAME.getCode(), circleList);
        return i;
    }


    /**
     * 获取弧线
     *
     * @param i        弧线开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     * @return 返回弧线读完的最后行数
     */
    private static int getArc(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        GeometricArc arc = new GeometricArc();
        while (true) {
            str = lineList.get(++i);
            //图层名
            if (ArcEnum.LAYER_NAME.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setGeometricName(str);
            }
            //圆弧圆心x坐标
            if (ArcEnum.COORDINATE_X.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_X);
                }
            }
            //圆弧圆心y坐标
            if (ArcEnum.COORDINATE_Y.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_Y);
                }
            }
            //圆弧圆心z坐标
            if (ArcEnum.COORDINATE_Z.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_Z);
                }
            }
            //圆弧半径
            if (ArcEnum.ARC_RADIUS.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setRadius(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_RADIUS);
                }
            }
            //圆弧起始角度
            if (ArcEnum.ARC_START_ANGLE.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setStartArc(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_START_ANGLE);
                }
            }
            //圆弧中止角度
            if (ArcEnum.ARC_END_ANGLE.getCode().equals(str)) {
                str = lineList.get(++i);
                arc.setEndArc(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.ARC_NOT_END_ANGLE);
                }
                break;
            }
        }
        List<GeometricObject> arcList = map.get(ArcEnum.ARC_NAME.getCode());
        if (arcList == null) {
            arcList = Lists.newArrayList();
        }
        arcList.add(arc);
        map.put(ArcEnum.ARC_NAME.getCode(), arcList);
        return i;
    }


    /**
     * 获取线
     *
     * @param i        线开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     * @return 返回直线读完的最后行数
     */
    private static int getLine(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        GeometricLine line = new GeometricLine();
        while (true) {
            str = lineList.get(++i);
            //图层名称
            if (LineEnum.LAYER_NAME.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setGeometricName(str);
            }
            //起点x坐标
            if (LineEnum.COORDINATE_X.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setStartX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_START_NOT_X);
                }
            }
            //起点y的坐标
            if (LineEnum.COORDINATE_Y.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setStartY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_START_NOT_Y);
                }
            }
            //起点z的坐标
            if (LineEnum.COORDINATE_Z.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setStartZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_START_NOT_Z);
                }
            }
            //终点的x坐标
            if (LineEnum.LINE_END_X_COORDINATES.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setEndX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_END_NOT_X);
                }
            }
            //终点的y坐标
            if (LineEnum.LINE_END_Y_COORDINATES.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setEndY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_END_NOT_Y);
                }
            }
            //终点的z坐标
            if (LineEnum.LINE_END_Z_COORDINATES.getCode().equals(str)) {
                str = lineList.get(++i);
                line.setEndZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.LINE_END_NOT_Z);
                }
                break;
            }
        }
        List<GeometricObject> linesList = map.get(LineEnum.LINE_NAME.getCode());
        if (linesList == null) {
            linesList = Lists.newArrayList();
        }
        linesList.add(line);
        map.put(LineEnum.LINE_NAME.getCode(), linesList);
        return i;
    }


    /**
     * 获取多线段
     *
     * @param i        多线段开始读取的行数
     * @param lineList 总数据
     * @param map      接收解析的数据map
     * @return 返回多线段读完最后行数
     */
    private static int getPolyLine(int i, List<String> lineList, Map<String, List<GeometricObject>> map) {
        String str = null;
        GeometricPolyLine polyLine = new GeometricPolyLine();
        List<GeometricVertex> vertices =Lists.newArrayList();
        while (true) {
            GeometricVertex vertex = new GeometricVertex();
            str = lineList.get(++i);
            //图层名字
            if (PolyLineEnum.LAYER_NAME.getCode().equals(str)) {
                str = lineList.get(++i);
                polyLine.setGeometricName(str);
            }
            //顶点的x坐标
            if (PolyLineEnum.COORDINATE_X.getCode().equals(str)) {
                str = lineList.get(++i);
                vertex.setX(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POLY_LINE_NOT_COORDINATE_X);
                }
            }
            //顶点的y坐标
            if (PolyLineEnum.COORDINATE_Y.getCode().equals(str)) {
                str = lineList.get(++i);
                vertex.setY(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POLY_LINE_NOT_COORDINATE_Y);
                }
            }
            //顶点的z坐标
            if (PolyLineEnum.COORDINATE_Z.getCode().equals(str)) {
                str = lineList.get(++i);
                vertex.setZ(new BigDecimal(str.trim()));
                if (!DecimalCheckUtil.check(str.trim())) {
                    throw new DxfAnalysisException(DxfAnalysisErrorEnum.POLY_LINE_NOT_COORDINATE_Z);
                }
                vertices.add(vertex);
            }
            //顶点结束
            if (PolyLineEnum.SEQEND.getCode().equals(str)) {
                polyLine.setVertexList(vertices);
                break;
            }
        }
        List<GeometricObject> polyLines = map.get(PolyLineEnum.POLYLINE_NAME.getCode());
        if (polyLines == null) {
            polyLines = Lists.newArrayList();
        }
        polyLines.add(polyLine);
        map.put(PolyLineEnum.POLYLINE_NAME.getCode(), polyLines);
        return i;
    }

    /**
     * 读取所有的行
     *
     * @param reader BufferedReader
     * @return 返回文件的所有数据，以每一行数据为一个item
     * @throws IOException IO异常
     */
    private static List<String> readAllLine(BufferedReader reader) throws IOException {
        List<String> list = Lists.newArrayList();
        String line = null;
        while ((line = reader.readLine()) != null) {
            list.add(line.trim());
        }
        return list;
    }


}