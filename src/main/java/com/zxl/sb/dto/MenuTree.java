package com.zxl.sb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode {
    private String name;

    private String permission;
    private String path;
    private String icon;
    private String component;
    private Integer sort;
    private String keepAlive;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date updateTime;

    //前端用 label就是名称  value就是id
    private String label;
    private String value;

}
