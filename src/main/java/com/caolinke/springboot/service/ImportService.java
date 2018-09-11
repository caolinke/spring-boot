package com.caolinke.springboot.service;

import com.caolinke.springboot.dao.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportService {

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean batchImport(String fileName, MultipartFile file) throws Exception{
        boolean notNull = false;
        List<Student> studentList = new ArrayList<>();
        if(!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")){
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if(fileName.matches("^.+\\.(?i)(xlsx)$")){
            isExcel2003 = false;
        }
        InputStream inputStream = file.getInputStream();
        Workbook workbook = null;
        if(isExcel2003){
            workbook = new HSSFWorkbook(inputStream);
        }else{
            workbook = new XSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        if(sheet != null){
            notNull = true;
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row == null){
                continue;
            }
            Student student = new Student();

            //先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);

            String id = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String sex = row.getCell(2).getStringCellValue();
            String age = row.getCell(3).getStringCellValue();
            String pno = row.getCell(4).getStringCellValue();
            String grade = row.getCell(5).getStringCellValue();
            String remark = row.getCell(6).getStringCellValue();

            System.out.println(id +", "+ name +", "+  sex+", " + age+", " + pno+", " +  grade+", " + remark);
        }
        return false;

    }
}
