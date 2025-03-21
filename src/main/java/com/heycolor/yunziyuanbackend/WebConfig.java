package com.heycolor.yunziyuanbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.tx-upload-dir}")
    private String txUploadDir;
    @Value("${file.data-upload-dir}")
    private String dataUploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将文件存储路径映射为 HTTP 访问路径
        registry.addResourceHandler("/uploads/tx/**")
                .addResourceLocations("file:" + txUploadDir + "/");
        // 将文件存储路径映射为 HTTP 访问路径
        registry.addResourceHandler("/uploads/data/**")
                .addResourceLocations("file:" + dataUploadDir + "/");
    }
}