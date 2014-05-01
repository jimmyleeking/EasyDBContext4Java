package com.handos.dbcontext.util;

/**
 * Created by jimmylee on 5/1/14.
 */
/**
 * 针对文本处理工具类
 *
 * @author Jimmy Lee
 *
 */
public class TextUtil {
    /**
     *  是否是空值或者NULL值
     * @param strArray
     * @return
     */
    public static boolean isNullOrEmpty(String... strArray) {

        for (String str : strArray) {
            if (str == null) {
                return true;
            }
            if (str.length() <= 0) {
                return true;
            }
        }
        return false;
    }
    
}
