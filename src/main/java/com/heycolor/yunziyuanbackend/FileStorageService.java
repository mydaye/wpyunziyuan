package com.heycolor.yunziyuanbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileStorageService {

    @Value("${file.tx-upload-dir}")
    private String txUploadDir;

    @Value("${file.data-upload-dir}")
    private String dataUploadDir;
    public String storeTxFile(MultipartFile file) throws IOException {
        // 确保上传目录存在
        Path uploadTxPath = Paths.get(txUploadDir);
        if (!Files.exists(uploadTxPath)) {
            Files.createDirectories(uploadTxPath);
        }

        // 获取文件后缀名
        String fileExtension = getFileExtension(file.getOriginalFilename());

        // 生成唯一的文件名（仅保留后缀名）
        String fileName = "tx"+generateTimestampFileName() + "." + fileExtension;

        // 保存文件
        Path filePath = uploadTxPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }

    public String storeDataFile(MultipartFile file) throws IOException {
        // 确保上传目录存在
        Path uploadPath = Paths.get(dataUploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 获取文件后缀名
        String fileExtension = getFileExtension(file.getOriginalFilename());

        // 生成唯一的文件名（仅保留后缀名）
        String fileName ="data" + generateTimestampFileName() + "." + fileExtension;

        // 保存文件
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }

    /**
     * 获取文件的后缀名
     *
     * @param fileName 文件名
     * @return 文件后缀名（如 "jpg", "png"）
     */
    private String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            throw new IllegalArgumentException("文件名不合法，缺少后缀名");
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    /**
     * 生成基于时间戳的文件名
     *
     * @return 基于时间戳的文件名（如 "20231010123045123"）
     */
    private String generateTimestampFileName() {
        // 格式化时间戳：yyyyMMddHHmmssSSS
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
}