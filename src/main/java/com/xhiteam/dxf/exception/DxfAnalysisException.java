package com.xhiteam.dxf.exception;

import com.xhiteam.dxf.enums.DxfAnalysisErrorEnum;

/**
 * @author fengwen
 * @version V1.0
 */
public class DxfAnalysisException extends DxfException {

    private static final long serialVersionUID = 2297430522517097373L;

    /**
     * 构造函数
     *
     * @param message 错误信息
     * @param cause   异常
     */
    public DxfAnalysisException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param message 错误信息
     */
    public DxfAnalysisException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param errorEnum DxfAnalysisErrorEnum
     */
    public DxfAnalysisException(DxfAnalysisErrorEnum errorEnum) {
        super(errorEnum.getMsg());
    }

}
