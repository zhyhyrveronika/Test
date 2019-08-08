package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class info {
	public WebDriver driver;

	public Properties prop;
	public WebDriver IntialDr() throws IOException{
		
		 prop =new Properties();
		FileInputStream file =new FileInputStream("C:\\Users\\Вероника\\MAtests\\src\\main\\java\\resources\\data.properties");
	
	prop.load(file);
	
	String browserName= prop.getProperty("browser");
	
	if (browserName.equals("chrome")){
		 System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	 driver = new ChromeDriver();
		
	}
	else if (browserName.equals("firefox")){
		driver = new FirefoxDriver();
	}
	else  if (browserName=="expl"){}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
}
