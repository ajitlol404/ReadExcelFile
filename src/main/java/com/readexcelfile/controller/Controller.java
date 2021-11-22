package com.readexcelfile.controller;

import com.readexcelfile.entity.Student;
import com.readexcelfile.helper.ExcelHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @PostMapping("/upload")
    public void readExcelFile(@RequestParam("file")MultipartFile file) throws IOException {

        if (ExcelHelper.hasExcelFormat(file))
        {
            List<Student> students = ExcelHelper.excelToStudent(file.getInputStream());
            System.out.println(students);
        }

    }






//    @PostMapping("/upload")
//    public void readExcelFile(@RequestParam("file")MultipartFile file) throws IOException {
//        List<Student> stdList=new ArrayList<Student>();
//        XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
//        XSSFSheet workSheet = workbook.getSheetAt(0);
//
//        for(int i=1;i<workSheet.getPhysicalNumberOfRows();i++)
//        {
//            Student std=new Student();
//
//            XSSFRow row = workSheet.getRow(i);
//            std.setId((int)row.getCell(0).getNumericCellValue());
//            std.setName(row.getCell(1).getStringCellValue());
//
//            stdList.add(std);
//        }
//
//        System.out.println(file.getContentType());
//        System.out.println("Data from file is : "+stdList);
//    }

}
