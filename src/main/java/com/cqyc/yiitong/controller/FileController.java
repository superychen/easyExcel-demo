package com.cqyc.yiitong.controller;

import com.cqyc.yiitong.comm.FileUtil;
import com.cqyc.yiitong.domain.CommEntity;
import com.cqyc.yiitong.domain.User;
import com.cqyc.yiitong.service.FileService;
import com.github.tobato.fastdfs.domain.FileInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author: cqyc
 * Description: 用fastdfs上传下载文件
 * Created by cqyc on 19-10-8
 */
@RestController
@RequestMapping("file")
@Api("fastdfs上传下载文件等操作")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传
     */
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件",notes = "上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "上传的文件",dataType = "MultipartFile")
    })
    public CommEntity uploadFile(@RequestParam("file") MultipartFile file){

        return CommEntity.create(fileService.uploadFile(file),200);
    }

    /**
     * 上传缩略图
     */
    @PostMapping("/upload/tumb")
    public CommEntity uploadTumbPic(@RequestParam("file") MultipartFile file){
        String[] pic = {"bmp", "dib", "gif", "jfif", "jpe", "jpeg", "jpg", "png", "tif", "tiff", "ico"};
        if(FileUtil.isFileType(file.getOriginalFilename(),pic)){
            return CommEntity.create(fileService.uploadCrtThumbImage(file),200);
        }else{
            throw new RuntimeException("文件类型出错");
        }
    }

    /**
     * 得到上传文件的类型
     */
    @GetMapping("/info")
    @ApiOperation(value = "查询文件信息",notes = "查询文件信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filePath",value = "文件路径",dataType = "String")
    })
    public CommEntity fileInfo(@RequestParam("filePath") String filePath){
        //group1/M00/00/00/wKgrDV2b7liAdNk2AA6-Ihmij-I692.jpg
        String groupName = StringUtils.substringBefore(filePath, "/");
        String path = StringUtils.substringAfter(filePath, "/");
        if(StringUtils.isAnyBlank(groupName,path)){
            throw new RuntimeException("得到的文件路径错误");
        }
        return CommEntity.create(fileService.fileInfo(groupName,path),200);
    }


    @DeleteMapping("/del/file")
    @ApiOperation(value = "删除对应文件",notes = "删除对应文件")
    @ApiImplicitParam(name = "filePath",value = "文件路径",dataType = "String")
    public CommEntity deleteFile(@RequestParam("filePath") String filePath){
        // group1/M00/00/00/wKgrDV2cFX-ATf7VABqs_qqWEVg685_150x150.jpg
        fileService.deleteFile(filePath);
        return CommEntity.create("删除成功",200);
    }

    @PostMapping("/download")
    @ApiOperation(value = "下载文件",notes = "下载文件")
    @ApiImplicitParam(name = "filePath",value = "文件路径",dataType = "string")
    public CommEntity downLoadFile(@RequestParam("filePath") String filePath){
        String groupName = StringUtils.substringBefore(filePath, "/");
        String path = StringUtils.substringAfter(filePath, "/");
        String lastFileName = FileUtil.subLastFileName(filePath);
        String fileName = UUID.randomUUID().toString().replaceAll("-","")+"."+lastFileName;
        return CommEntity.create(fileService.downLoadFile(groupName,path,fileName),200);
    }

    /**
     * 这个是测试设置返回实体类时，有些重要数据不需要返回
     */
    @GetMapping("/user")
    public CommEntity userTest(){
        User user = new User();
        user.setUsername("sdfa");
        user.setPassword("123456");
        return CommEntity.create(user,200);
    }


}
