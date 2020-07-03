package com.xhiteam.dxf;

import com.xhiteam.dxf.collector.DxfCollector;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author fengwen
 * @Date 2020/1/12 15:48
 * @Version V1.0
 */
public class BaseTest {

    public File file = new File("C:\\Users\\华硕电脑\\Desktop\\数据解析\\cdx171761_scenario.dxf");
    //C:\Users\华硕电脑\Desktop\数据解析\cdx171761_scenario.dxf
    //G:\测试案例数据\测试案例数据\xhf183022_scenario\xhf183022_scenario.dxf

    public DxfCollector collector;

    {
        try {
            collector = DXF.build(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
