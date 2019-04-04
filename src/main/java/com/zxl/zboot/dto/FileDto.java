package com.zxl.zboot.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/6
 */
@Data
public class FileDto implements Serializable {

    /**
     * 新文件名称
     */
    private String newFileName;

    /**
     * 源文件名称
     */
    private String originalFileName;

    /**
     * 后缀
     */
    private String suffix;

    /**
     * 文件大小
     */
    private String volume;
}
