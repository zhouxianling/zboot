package com.zxl.demo.entity;

import com.zxl.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zxl
 * @since 2019-03-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysFile extends BaseEntity {

    private static final long serialVersionUID = 1L;


    public SysFile(String newFileName, String originalFileName, String suffix, String volume) {
        this.newFileName = newFileName;
        this.originalFileName = originalFileName;
        this.suffix = suffix;
        this.volume = volume;
    }


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
