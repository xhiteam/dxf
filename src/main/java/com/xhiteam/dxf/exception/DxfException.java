package com.xhiteam.dxf.exception;

/**
 * @author janzhao you
 * @version V1.0
 */
public class DxfException extends RuntimeException {

    private static final long serialVersionUID = 573279654770805998L;

    /**
     * 构造函数
     *
     * @param message 错误信息
     * @param cause   异常
     */
    public DxfException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param message 错误信息
     */
    public DxfException(String message) {
        super(message);
    }
}
