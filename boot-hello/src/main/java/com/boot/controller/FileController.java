package com.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String upload(HttpServletRequest request,
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
