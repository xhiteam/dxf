package com.xhiteam.dxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author fengwen
 * @Description 基本的dxf对象类
 * @Date 2019/12/11 19:30
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class GeometricObject implements Serializable {

    private static final long serialVersionUID = 154930463320039374L;

    /**
     * dxf对象id
     */
    private Long id;

    /**
     * dxf对象名称
     */
    private String geometricName;

    /**
     * dxf对象图层名
     */
    private String geometricLayer;


}
