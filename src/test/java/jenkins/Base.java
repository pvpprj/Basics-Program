package jenkins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties p;

	public WebDriver InitializingDriver() throws IOException { // Properties Class
		p = new Properties();
		FileInputStream f = new FileInputStream("src\\test\\java\\jenkins\\Data_Properties");
		
		p.load(f);
		String browsername = p.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Rahul\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (browsername.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "File\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browsername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "File\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
