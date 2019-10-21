package com.cqyc.yiitong.comm;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-8
 */
public class FileUtil {

    /**
     * todo 有一个问题,如果fastdfs上传的文件名有两个点,则只能选出最后一个点
     * 获取文件的后缀名
     * @param filename 文件名
     * @return string
     */
    public static String subLastFileName(String filename) {
        String res = StringUtils.substringAfterLast(filename, ".");
        if (StringUtils.isBlank(res)) {
            throw new RuntimeException("获取文件后缀名为空,请仔细检查");
        }
        return res;
    }


    /**
     * 判断文件类型是否跟传递的数组中类型匹配
     * @param filename 文件名
     * @param verArray 需要校验的类型数组
     * @return string
     */
    public static boolean isFileType(String filename, String[] verArray) {
        // 文件名称为空的场合
        if (StringUtils.isBlank(filename)) {
            // 返回不和合法
            return false;
        }
        // 获得文件后缀名
        String tmpName = subLastFileName(filename);
        // 遍历名称数组
        for (int i = 0; i < verArray.length; i++) {
            // 判断单个类型文件的场合
            if (StringUtils.equals(verArray[i], tmpName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }



}
