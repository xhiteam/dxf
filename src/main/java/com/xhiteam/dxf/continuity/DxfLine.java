package com.xhiteam.dxf.continuity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Description dxf点线数据Line
 * @Author fengwen
 * @Date 2019/12/11 19:58
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class DxfLine implements Serializable {

    private static final long serialVersionUID = -8270659674597044220L;

    /**
     * 线编号
     */
    private Long lineNum;

    /**
     * 图层名
     */
    private String layerName;

    /**
     * 组成线的点
     */
    private List<DxfPoint> dataPointList;

}
