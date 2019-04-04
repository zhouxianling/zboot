package com.zxl.zboot.service;

import com.zxl.zboot.entity.SysFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-05
 */
public interface ISysFileService extends IService<SysFile> {

    /**
     * @param file 单个文件上传
     * @return SysFile
     */
    SysFile upload(MultipartFile file);


    /**
     * @param files 单个文件上传
     * @return List<SysFile>
     */
    List<SysFile> uploads(MultipartFile[] files);


}
