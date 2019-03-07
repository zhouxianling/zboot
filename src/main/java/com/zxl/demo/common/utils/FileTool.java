package com.zxl.demo.common.utils;


/**
 * There is no royal road to learning.
 * Description:
 * Created by XianLing on 2018/03/22 17:14
 */
public class FileTool {

    private static final String FOLDER_SEPARATOR = "/";
    private static final char EXTENSION_SEPARATOR = '.';

    /**
     * 获取文件大小
     *
     * @param size
     * @return
     */
    public static String getVolume(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }

    /**
     * 获取文件后缀
     *
     * @param file
     * @return
     */
    public static String getFileSuffix(String file) {
        if (file == null) {
            return null;
        }
        int extIndex = file.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1) {
            return null;
        }
        int folderIndex = file.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex) {
            return null;
        }
        return file.substring(extIndex);
    }

}