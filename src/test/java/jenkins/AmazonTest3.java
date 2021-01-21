package jenkins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AmazonTest3 extends Base{

	public WebDriver driver;
	

	@BeforeTest
	public void BrowseInt() throws Exception
	{
		driver = InitializingDriver();
		driver.get(p.getProperty("url"));
		Thread.sleep(3000);	
	}
	
	@Test
	public void amazone() throws InterruptedException, IOException
	{
		Actions a = new Actions(driver);

		WebElement signIn = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		a.moveToElement(signIn).build().perform();
		
		WebElement sig = driver.findElement(By.xpath("//span[@class='nav-action-inner'][1]"));
		sig.click();
		
		WebElement mob = driver.findElement(By.xpath("//input[@id='ap_email']"));
		mob.sendKeys("98675332333");

		driver.findElement(By.xpath("//input[@id='continue']")).click();
	}
	
	
	@Test
	public void createAmazoneAccount() throws InterruptedException, IOException
	{
		WebElement newAccount = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
		newAccount.click();
	
		WebElement yourname = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		yourname.sendKeys("rahul");
		
		WebElement mobileNum = driver.findElement(By.xpath("//input[@id='ap_phone_number']"));
		mobileNum.sendKeys("98765dd55");
	
		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys("gsgs@hhs.com");
	
		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys("hhhdddjj");
		
		WebElement submit = driver.findElement(By.xpath("//input[@id='continue']"));
		submit.click();

				WebElement error =	driver.findElement(By.xpath("//div[contains(text(),'The mobile number you entered does not seem to be')]"));
						String errorMessage = error.getText();
		String Expected = "The mobile number you entered does not seem to be valid";

		Assert.assertEquals(Expected, errorMessage);
		System.out.println("error mSG : " + error);
	}
	
	@AfterTest
	public void last()
	{
		driver.close();
	}  
}


//input[@id='ap_customer_name']