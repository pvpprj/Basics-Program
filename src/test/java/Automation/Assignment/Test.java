package Automation.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITest;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

	/*	System.setProperty("webdriver.chrome.driver", "File\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		File src = new File("File\\resources\\data\\MetaData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String username = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("username : "+username);
		String Password = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Password : "+Password);

		driver.get("https://www.irctc.co.in");
		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
		WebElement Login = driver.findElement(By.xpath("//a[@id='loginText']"));
		Login.click();

		Thread.sleep(2000);
		WebElement user = driver.findElement(By.xpath("//input[@id='userId']"));
		user.sendKeys(username);
		Thread.sleep(2000);
		WebElement pass = driver.findElement(By.xpath("//input[@id='pwd']"));
		pass.sendKeys(Password);

		Thread.sleep(5000);

		/*
		 * File src = driver.findElement(By.xpath(
		 * "//div[@id='nlpImgContainer']//div//div//div//div//div//img"))
		 * .getScreenshotAs(OutputType.FILE); String path =
		 * System.getProperty("user.dir")+"/screenshots/captcha.png";
		 * FileHandler.copy(src, new File(path));
		 * 
		 * ITesseract image = new Tesseract(); String imagetext = image.doOCR(new
		 * File(path));
		 * 
		 * String finalText = imagetext.split("below")[1].replaceAll("[^a-zA-Z]", "");
		 * System.out.println("Final Captha is : "+finalText);
		 * 
		 */

	/*	WebElement captcha = driver.findElement(By.xpath("//input[@id='nlpAnswer']"));
		captcha.sendKeys("finalText");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();

		String expected = "Invalid Captcha....";
		WebElement er = driver.findElement(By.xpath("//div[@class='loginError']"));
		String error = er.getText();
		// String error1 = er.toString();
		System.out.println(error);
		// Assert.assertEquals(error, expected);    */
		
		
		int x=4;
		int y=5;
		int p=0;
		
		while(y!=0)
		{
			p=p+x;
			y--;
			
		}
		
		System.out.println(p);

	}
}