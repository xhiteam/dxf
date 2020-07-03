package com.xhiteam.dxf.util;

import com.google.common.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 判断是否为小数
 * @Author youjianzhao
 * @Date 2020/2/1 10:28
 * @Version
 */
public class DecimalCheckUtil {

    /**
     * 判断是否为小数
     *
     * @param checkStr
     * @return
     */
    public static boolean check(String checkStr) {
        if (!Strings.isNullOrEmpty(checkStr)) {
            String regExp = "-{0,1}\\d+\\.\\d+";
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(checkStr);
            return matcher.matches();
        }
        return false;
    }
}
