package com.chen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FIleController {

    // 原始的使用流上传文件
    // 批量上传的话CommonsMultipartFile为数组即可
    @RequestMapping("/uploadFile1")
    public String uploadFile1(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        if ("".equals(filename)) {
            return "redirect:/file.jsp";
        }
        System.out.println("上传文件名：" + filename);

        // 上传路径
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File realPath = new File(uploadPath);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件保存地址：" + realPath);

        // 输入输出流
        InputStream is = file.getInputStream();
        FileOutputStream os = new FileOutputStream(new File(realPath, filename));

        int len=0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();
        return uploadPath + filename;
    }

    // 使用 file.transferTo 来上传文件
    @RequestMapping("/uploadFile2")
    public String uploadFile2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        if ("".equals(filename)) {
            return "redirect:/file.jsp";
        }
        System.out.println("上传文件名：" + filename);

        // 上传路径
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File realPath = new File(uploadPath);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件保存地址：" + realPath);

        // 上传
        file.transferTo(new File(realPath + "/" + filename));

        return uploadPath + filename;
    }
}
