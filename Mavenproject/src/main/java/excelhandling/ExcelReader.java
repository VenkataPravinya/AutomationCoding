package excelhandling;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ExcelReader{

    public void excelReader() throws FileNotFoundException {

        String path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(new File(path + "\\src\\main\\resources\\datasheet\\TEST.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.getSheet("User details");



    }



}
