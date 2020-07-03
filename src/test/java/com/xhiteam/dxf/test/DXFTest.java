package com.xhiteam.dxf.test;


import com.xhiteam.dxf.BaseTest;
import com.xhiteam.dxf.entity.GeometricObject;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DXFTest extends BaseTest {

    @Test
    public void build() {
        Map<String, List<GeometricObject>> listMap = collector.getMap();
        System.out.println(listMap);
    }
}
