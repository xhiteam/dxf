package com.xhiteam.dxf.collector.impl;

import com.xhiteam.dxf.BaseTest;
import com.xhiteam.dxf.continuity.DxfLine;
import com.xhiteam.dxf.entity.GeometricArc;
import com.xhiteam.dxf.entity.GeometricCircle;
import com.xhiteam.dxf.entity.GeometricObject;
import com.xhiteam.dxf.entity.GeometricPolyLine;
import com.xhiteam.dxf.util.DecimalCheckUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class DxfCollectorImplTest extends BaseTest {


    @Test
    public void getMap() {
        Map<String, List<GeometricObject>> map = collector.getMap();
        System.out.println(map);
    }

    @Test
    public void getDxfLineList() {
        List<DxfLine> dxfLineList = collector.getDxfLineList();
        System.out.println(dxfLineList);
    }

    @Test
    public void getGeometricPointList() {
        List<DxfLine> dxfLineList = collector.getDxfLineList();
        System.out.println(dxfLineList);
    }

    @Test
    public void getGeometricLineList() {
        List<DxfLine> dxfLineList = collector.getDxfLineList();
        System.out.println(dxfLineList);
    }

    @Test
    public void getGeometricArcList() {
        List<GeometricArc> arcList = collector.getGeometricArcList();
        System.out.println(arcList);
    }

    @Test
    public void getGeometricCircleList() {
        List<GeometricCircle> circleList = collector.getGeometricCircleList();
        System.out.println(circleList);
    }

    @Test
    public void getGeometricPolyLineList() {
        List<GeometricPolyLine> polyLineList = collector.getGeometricPolyLineList();
        System.out.println(polyLineList);
    }

    @Test
    public void checkTest() {
        String test = "1.0";
        String test1 = null;
//        BigDecimal unTest = BigDecimal.valueOf(test);
//        System.out.println(DecimalCheckUtil.check(new BigDecimal(test)));
//        System.out.println(DecimalCheckUtil.check(new BigDecimal(test1)));
        BigDecimal x = null;
        if (DecimalCheckUtil.check("0.1")) {
            System.out.println(1);
        }
    }
}
