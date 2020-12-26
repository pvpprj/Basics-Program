package Automation.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {
// src\\test\\resources\\data\\.xlsx
	//File\resources\data\MetaData.xlsx
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File src = new File("File\\resources\\data\\MetaData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String username = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("username : "+username);
		int Password = (int) sheet1.getRow(0).getCell(1).getNumericCellValue();
		System.out.println("Password : "+Password);
		
	
		
		wb.close();

	}
}