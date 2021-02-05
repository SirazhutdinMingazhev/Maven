package SeleniumProgramms;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrittingDemo {

    public static void main(String[] args) throws IOException {
        File f=new File("/Users/sirazhutdinmingazhev/Desktop/SeleniumWorkFolder/ExcelFileForSelenium.xlsx"); // Create an object of File class to open xlsx file
        FileInputStream fi=new FileInputStream(f); //Create an object of FileInputStream class to read excel file // or enter excel file path instead of (f)
        XSSFWorkbook wb=new XSSFWorkbook(fi); // creating object for workbook
        XSSFSheet sh=wb.getSheet("Sheet2"); // reading sheet


        XSSFSheet sheet=wb.createSheet("createdSheet");

        sh.createRow(5).createCell(5).setCellValue("Hello hello");

        XSSFRow row=sh.createRow(4);
        XSSFCell cell=row.createCell(2);
        cell.setCellValue("Welcome to excell writting");

        FileOutputStream fo=new FileOutputStream(f);
        wb.write(fo); // save data in excel


        fo.close();
        wb.close();
        fi.close();

    }

}
