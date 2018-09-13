package com.caolinke.springboot.controller;

import com.caolinke.springboot.service.ImportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@RestController
public class ImportController {

    @Resource
    private ImportService importService;

    @RequestMapping("/import")
    public String batchImport(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        int batchNum;
        try {
            batchNum = importService.addStudent(fileName,file);
            System.out.println("插入数据成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return "阿喔！出错了...";
        }
        if (batchNum != -1) {
            return "插入数据成功";
        } else {
            return "插入数据失败";
        }

    }
}
