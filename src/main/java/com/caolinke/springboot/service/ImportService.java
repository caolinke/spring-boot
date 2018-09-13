package com.caolinke.springboot.service;

import com.caolinke.springboot.dao.StudentDao;
import com.caolinke.springboot.dao.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImportService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 插入数据
     * @param fileName
     * @param file
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int addStudent(String fileName, MultipartFile file) {
        List<Student> studentList = new ArrayList<>();
        List<String> list = null;
        try {
            list = this.batchImport(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("excel表格解析失败");
        }
        for (String studentStr : list) {
            Student student = new Student();
            String[] strings = studentStr.split("-");
            student.setId(Integer.parseInt(strings[0]));
            student.setName(strings[1]);
            student.setSex(Integer.parseInt(strings[2]));
            student.setAge(Integer.parseInt(strings[3]));
            student.setPno(strings[4]);
            student.setGrade(strings[5]);
            student.setRemark(strings[6]);
            studentList.add(student);
        }
        int num = studentDao.addStudentList(studentList);
        System.out.println("执行完毕！");
        if (num == studentList.size()) {
            return num;
        } else {
            return -1;
        }


    }

    /**
     * 处理Excel表格中的数据
     * @param file
     * @return
     * @throws Exception
     */

    public List<String> batchImport(MultipartFile file) throws Exception{
        InputStream inputStream = file.getInputStream();
        //创建workbook对象
        Workbook workbook = WorkbookFactory.create(inputStream);
        List<String> list = new ArrayList<>();
        //遍历所有的shteet
        //for (int i = 0; i <workbook.getNumberOfSheets(); i++) {
                System.out.println(workbook.getSheetName(0));
                //得到sheet对象
                Sheet sheet = workbook.getSheetAt(0);
                //遍历该sheet下所有的行
                for (int rows = 1; rows < sheet.getPhysicalNumberOfRows(); rows++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    //获得行对象
                    Row row = sheet.getRow(rows);
                    if (row == null) {
                        continue;
                    }
                    //得到表格
                    for (int cells = 0; cells < row.getPhysicalNumberOfCells(); cells++) {
                        Cell cell = row.getCell(cells);
                        if (cell == null) {
                            continue;
                        }
                        switch (cell.getCellType()) {
                            case  Cell.CELL_TYPE_NUMERIC :
                                stringBuilder.append(cell.getNumericCellValue()+"-");
                                System.out.println(cell.getNumericCellValue());
                                break;
                            case Cell.CELL_TYPE_STRING :
                                stringBuilder.append(cell.getStringCellValue()+"-");
                                System.out.println(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN :
                                stringBuilder.append(cell.getBooleanCellValue()+"-");
                                System.out.println(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_FORMULA :       //表达式类型
                                stringBuilder.append(cell.getCellFormula()+"-");
                                System.out.println(cell.getCellFormula());
                                break;
                            default:
                                System.out.println("---");
                        }
                    }
                    list.add(stringBuilder.toString());
                }
        //}
        return list;

    }
}
