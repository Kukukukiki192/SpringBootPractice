package com.example.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.path}")
    private String path;

    @PostMapping("/")
    public String upload(){
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        File dest = new File(filePath);
//        file.transferTo(dest);
        Files.copy(file.getInputStream(),dest.toPath()); //(Path source, OutputStream out)
        return "Upload file success : " + dest.getAbsolutePath();
    }

    @PostMapping("/upload1")
    public String upload1(HttpServletRequest request,
                         @RequestPart("img") MultipartFile img,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：imgSize={},photosLength={}", img.getSize(),photos.length);
        //上传的位置
//        String path=request.getSession().getServletContext().getRealPath("/uploads");
//        //判定路径是否存在
//        File file=new File(path);
//        if(!file.exists()){
//            file.mkdir();//若不存在 创建该文件夹
//        }

        String path="D:/";

        //文件不为空则上传
        //单文件
        if(!(img.isEmpty())){
            String fileName = img.getOriginalFilename();
            img.transferTo(new File(path,fileName));
        }
        //多文件
        if(photos.length>0){
            for(MultipartFile photo:photos){
                if(!(photo.isEmpty())){
                    String fileName = photo.getOriginalFilename();
                    photo.transferTo(new File(path,fileName));
                }
            }
        }

        return "upload success!";
    }
}
