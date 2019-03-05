package com.zxl.demo.controller;


import com.zxl.demo.entity.SysFile;
import com.zxl.demo.mapper.SysFileMapper;
import com.zxl.demo.service.ISysFileService;
import com.zxl.demo.utils.FileTool;
import com.zxl.demo.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import com.zxl.demo.common.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-05
 */
@Api(tags = "2", value = "上传接口", description = "上传接口")
@RestController
@RequestMapping("/sysFile")
public class SysFileController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);
    private static final String DIR = "/E:/file/";


    @Autowired
    ISysFileService sysFileService;

    @ApiOperation("单文件上传")
    @PostMapping("/upload")
    @ResponseBody
    public R upload(@RequestParam("file") MultipartFile file) throws IOException {
        return new R<>(saveFile(file));
    }

    @ApiOperation("多文件上传")
    @PostMapping("/uploads")
    @ResponseBody
    public Object uploads(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<SysFile> results = new ArrayList<>(18);
        for (MultipartFile file : files) {
            results.add(saveFile(file));
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
        file.transferTo(new File(DIR + newFileName));
        SysFile sysFile = new SysFile(newFileName, file.getOriginalFilename(), suffix, FileTool.getVolume(file.getSize()));
        sysFileService.save(sysFile);
        return sysFile;
    }
}
