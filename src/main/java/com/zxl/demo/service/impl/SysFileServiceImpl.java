package com.zxl.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.entity.SysFile;
import com.zxl.demo.exception.CustomException;
import com.zxl.demo.mapper.SysFileMapper;
import com.zxl.demo.service.ISysFileService;
import com.zxl.demo.utils.FileTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-05
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {


    @Value(value = "file-dir")
    private String fileDir;


    @Override
    public SysFile upload(MultipartFile file) {
        try {
            return saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysFile> uploads(MultipartFile[] files) {
        if (files == null || files.length == 0) {
            throw new CustomException(400, "别整点空的资源上来，不得行！");
        }
        List<SysFile> results = new ArrayList<>(18);
        for (MultipartFile file : files) {
            try {
                results.add(saveFile(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


    /**
     * 保存单个文件的方法
     *
     * @param file
     * @throws IOException
     */
    private SysFile saveFile(MultipartFile file) throws IOException {
        // TODO 获取文件后缀
        String suffix = FileTool.getFileSuffix(file.getOriginalFilename());
        String newFileName = UUID.randomUUID() + suffix;
        // TODO 将文件写入到指定目录
        file.transferTo(new File(fileDir + newFileName));
        SysFile sysFile = new SysFile(newFileName, file.getOriginalFilename(), suffix, FileTool.getVolume(file.getSize()));
        this.save(sysFile);
        return sysFile;
    }

}
