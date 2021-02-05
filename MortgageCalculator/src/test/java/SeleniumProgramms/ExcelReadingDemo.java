package SeleniumProgramms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingDemo {

    public static void main(String[] args) throws IOException {
        File f=new File("/Users/sirazhutdinmingazhev/Desktop/SeleniumWorkFolder/ExcelFileForSelenium.xlsx"); // Create an object of File class to open xlsx file

        FileInputStream fi=new FileInputStream(f); //Create an object of FileInputStream class to read excel file // or enter excel file path instead of (f)

        XSSFWorkbook wb=new XSSFWorkbook(fi); // creating object for workbook

        XSSFSheet sh=wb.getSheet("Sheet1"); // reading sheet
        int row_count=sh.getLastRowNum(); // getting the number of rows on current sheet
        System.out.println(row_count+" rows");

        XSSFRow row=sh.getRow(0); // reading row
        int column_count=row.getLastCellNum();
        System.out.println(column_count+" columns");

        XSSFCell cell=row.getCell(1); // reading cell

        cell.getStringCellValue();
        System.out.println(cell.getStringCellValue());



        wb.close();
        fi.close();

    }

}
