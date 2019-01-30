package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 不认证权限的路径
 */
@Controller
@RequestMapping("/open")
public class OpenController {

    public static final String UPLOADED_FOLDER = "/Users/yuhang/upload/";


    @GetMapping("/test1")
    public String test1() {
        return "open/test1";
    }

    @GetMapping("test2")
    public String test2() {
        return "open/test2";
    }

    @GetMapping("upload")
    public String upload(){
        return "open/upload";
    }

    /**
     * 上传文件
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload/file")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "open/upload_status";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            try {

                boolean pathExists =
                        Files.exists(Paths.get(UPLOADED_FOLDER),
                                LinkOption.NOFOLLOW_LINKS);

                if (!pathExists) {
                    Files.createDirectory(Paths.get(UPLOADED_FOLDER));
                }

                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "open/upload_status";

    }
}
