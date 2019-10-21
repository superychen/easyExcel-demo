package com.cqyc.yiitong.service.impl;

import com.cqyc.yiitong.comm.FileUtil;
import com.cqyc.yiitong.service.FileService;
import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-8
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Value("${fastdfs.host}")
    private String hostIp;

    /**
     * 上传文件
     * @param file 上传的文件
     */
    @Override
    public String uploadFile(MultipartFile file) {
        try {
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                    FileUtil.subLastFileName(file.getOriginalFilename()), null);
            String fileUrl =hostIp + "/" + storePath.getFullPath();
            log.info("上传得到的fileUrl---->{}",fileUrl);
            return fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过fastdfs图片上传缩略图
     * @param file 图片文件
     * @return
     */
    @Override
    public String uploadCrtThumbImage(MultipartFile file) {
        try {
            StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
                    FileUtil.subLastFileName(file.getOriginalFilename()), null);
            String fullPath = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
            log.info("【图片缩略图带有组名的路径】:{}",fullPath);
            return fullPath;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 查询fastdfs文件的信息
     * @param groupName 指定哪一个组
     * @param path 文件存储的路径
     * @return
     */
    @Override
    public FileInfo fileInfo(String groupName, String path) {
        FileInfo fileInfo = storageClient.queryFileInfo(groupName, path);
        log.info("192.168.43.13得到上传文件的信息---->{}",fileInfo);
        return fileInfo;
    }

    /**
     * 删除文件
     * @param filePath 给出文件路径
     */
    @Override
    public void deleteFile(String filePath) {
        storageClient.deleteFile(filePath);
    }

    /**
     * 下载文件
     * @param groupName 指定哪一个组
     * @param path 文件存储的路径
     * @param fileName 下载的文件名
     * @return string
     */
    @Override
    public String downLoadFile(String groupName, String path, String fileName) {
        DownloadFileWriter callback = new DownloadFileWriter(fileName);
        String res = storageClient.downloadFile(groupName, path, callback);
        return res;
    }

}
