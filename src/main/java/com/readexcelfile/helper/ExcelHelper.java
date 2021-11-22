package com.readexcelfile.helper;

import com.readexcelfile.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; //this is content type of excel file

    public static String[] Headers = {"Id", "Name", "Father Name", "Mother Name", "Mobile Number"};

    public static String SHEET = "Student";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equalsIgnoreCase(file.getContentType()))
            return false;

        return true;
    }

    public static List<Student> excelToStudent(InputStream stream) throws IOException {
       Workbook workbook = new XSSFWorkbook(stream);

        Sheet sheet = workbook.getSheet(SHEET);
        Iterator<Row> rows = sheet.iterator();

        List<Student> students=new ArrayList<>();

        int rowNumber = 0;

        while (rows.hasNext())
        {
            Row currentRow = rows.next();

            //skip header
            if(rowNumber == 0)
            {
                rowNumber++;
                continue;
            }

            Iterator<Cell> cellsInRow = currentRow.iterator();

            Student student=new Student();

            int cellIdx = 0;
            while (cellsInRow.hasNext())
            {
                Cell currentCell = cellsInRow.next();
                switch(cellIdx)
                {
                    case 0:
                        student.setId((int) currentCell.getNumericCellValue());
                        break;
                    case 1:
                        student.setName(currentCell.getStringCellValue());
                        break;
                    case 2:
                        student.setFatherName(currentCell.getStringCellValue());
                        break;
                    case 3:
                        student.setMotherName(currentCell.getStringCellValue());
                        break;
                    case 4:
                        student.setMobileNumber((int) currentCell.getNumericCellValue());
                        break;
                    default:
                        break;
                }
                cellIdx++;
            }
            students.add(student);
        }
        workbook.close();;
        return students;
    }


}
