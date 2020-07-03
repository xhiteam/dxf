package com.xhiteam.dxf;

import com.xhiteam.dxf.collector.DxfCollector;
import com.xhiteam.dxf.collector.impl.DxfCollectorImpl;
import com.xhiteam.dxf.constant.FileConstant;
import com.xhiteam.dxf.enums.DxfFileErrorEnum;
import com.xhiteam.dxf.exception.DxfFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description DXF入口
 * @Author fengwen
 * @Date 2019/12/21 20:46
 * @Version V1.0
 */
public class DXF {

    /**
     * 上传文件、返回DXF数据采集者
     *
     * @param file 上传的文件
     * @return 数据采集者
     */
    public static DxfCollector build(File file) throws IOException {
        if (file == null) {
            throw new FileNotFoundException();
        }
        if (!file.getName().endsWith(FileConstant.FILE_EXTENSION)) {
            throw new DxfFileException(DxfFileErrorEnum.DXF_FILE_ERROR.getMsg() + file.getName());
        }
        return new DxfCollectorImpl(file);
    }

    /**
     * 通过文件文件路径、返回DXF数据采集者
     *
     * @param filePath 文件路径
     * @return 数据采集者
     */
    public static DxfCollector build(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!file.getName().endsWith(FileConstant.FILE_EXTENSION)) {
            throw new DxfFileException(DxfFileErrorEnum.DXF_FILE_ERROR.getMsg() + file.getName());
        }
        return new DxfCollectorImpl(file);
    }

}
