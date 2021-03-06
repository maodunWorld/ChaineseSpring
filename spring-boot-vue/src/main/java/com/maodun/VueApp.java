package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author tongjian
 * @date 2020/6/3 8:59
 */
@SpringBootApplication
@RestController
public class VueApp {
    public static void main(String[] args) {

        SpringApplication.run(VueApp.class, args);
    }

    @PostMapping("/up")
    public String upload(MultipartFile file) throws IOException {
        String filePath = "d:/" + file.getOriginalFilename();
        File newFile = new File(filePath);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 文件存储
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }
}
