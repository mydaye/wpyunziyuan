package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.service.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

import static com.heycolor.yunziyuanbackend.constant.StateCode.*;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {
    private final userService xUser;
    private final FileStorageService fileStorageService;

    public FileUploadController(userService xUser, FileStorageService fileStorageService) {
        this.xUser = xUser;
        this.fileStorageService = fileStorageService;
    }
    // 允许上传的图片文件类型
    private static final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList(
            "image/jpeg", "image/png", "image/gif", "image/jpg"
    );
//推送测试
    @PostMapping("/tx")
    public ResponseEntity<ReturnInfo> uploadTxImage(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("user_number") String user_number,
                                                  @RequestParam("user_login_key") String user_login_key) {
        boolean uTest = xUser.userByLoginTest(user_number,user_login_key);
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        try {
            // 检查文件类型
            if (isAllowedImageType(file)) {
                return ResponseEntity.badRequest()
                        .body(ReturnInfo.res(NOT_LOGGED_IN, "文件类型不支持", null));

            }
            // 保存文件并获取文件名
            String fileName = fileStorageService.storeTxFile(file);
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(SUCCESS, "", fileName));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(NOT_LOGGED_IN, e.getMessage(), null));
        }
    }
    @PostMapping("/data")
    public ResponseEntity<ReturnInfo> uploadDataImage(@RequestParam("file") MultipartFile file) {
        try {
            // 检查文件类型
            if (isAllowedImageType(file)) {
                return ResponseEntity.badRequest()
                        .body(ReturnInfo.res(NOT_LOGGED_IN, "文件类型不支持", null));

            }
            // 保存文件并获取文件名
            String fileName = fileStorageService.storeDataFile(file);
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(SUCCESS, "", fileName));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(NOT_LOGGED_IN, e.getMessage(), null));
        }
    }

    /**
     * 检查文件类型是否为允许的图片类型
     *
     * @param file 上传的文件
     * @return 如果是允许的图片类型，返回 true；否则返回 false
     */
    private boolean isAllowedImageType(MultipartFile file) {
        String fileContentType = file.getContentType();
        return fileContentType == null || !ALLOWED_IMAGE_TYPES.contains(fileContentType.toLowerCase());
    }
}