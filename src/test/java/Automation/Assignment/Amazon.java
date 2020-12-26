package Automation.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Amazon {

//	WebElement signIn = driver.findElement(By.xpath(""));
	public static void main(String[] args) throws InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vishal\\Downloads\\chromedriver_win32(9)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		Actions a = new Actions(driver);

		WebElement signIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[@class='nav-line-1']"));
		a.moveToElement(signIn).build().perform();

		WebElement sig = driver.findElement(By.xpath("//span[@class='nav-action-inner'][1]"));
		sig.click();
		Thread.sleep(2000);

		WebElement newAccount = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
		newAccount.click();
		Thread.sleep(2000);

		File src = new File("File\\resources\\data\\MetaData.xlsx");
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String name = sheet1.getRow(0).getCell(0).getStringCellValue();
		String mobile = sheet1.getRow(0).getCell(1).getStringCellValue();
		String mail = sheet1.getRow(0).getCell(2).getStringCellValue();
		String pass = sheet1.getRow(0).getCell(3).getStringCellValue();

		WebElement yourname = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		yourname.sendKeys(name);
		Thread.sleep(2000);

		WebElement mobileNum = driver.findElement(By.xpath("//input[@id='ap_phone_number']"));
		mobileNum.sendKeys(mobile);
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys(mail);
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys(pass);
		Thread.sleep(2000);

		WebElement submit = driver.findElement(By.xpath("//input[@id='continue']"));
		submit.click();

				WebElement error =	driver.findElement(By.xpath("//div[contains(text(),'The mobile number you entered does not seem to be')]"));
						String errorMessage = error.getText();
		String Expected = "The mobile number you entered does not seem to be valid";

		Assert.assertEquals(Expected, errorMessage);
		System.out.println("error mSG : " + error);
	}
}

//input[@id='ap_customer_name']