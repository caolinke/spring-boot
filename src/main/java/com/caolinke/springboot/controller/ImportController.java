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
    public boolean batchImport(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = importService.batchImport(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}
