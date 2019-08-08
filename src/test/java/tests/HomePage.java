package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import resources.info;

public class HomePage extends info {
	 
	@BeforeSuite
	public void init() throws IOException{
		driver=IntialDr();
		
	}
	@BeforeTest
	public void profileSetup() {
	    driver.manage().window().maximize();
	    System.out.println("The profile setup process is completed");
	}
	@BeforeClass
	public void appSetup() {
		driver.get("https://misteram.com.ua/chernigov");
		
	}
		
@Test(groups={"Search"})
public void SearchTest() throws InterruptedException{
	HomePageObj hpo =new HomePageObj(driver);
    String array [] = {"Georgia","georgia","GEO"};
    for(int i=0;i<=array.length-1;i++)
    {     hpo.getsearchF().clear();
    	hpo.getsearchF().sendKeys(array[i]);
    	hpo.getsearchB().click();
    	   Thread.sleep(3000);
    	   WebElement status = driver.findElement(By.linkText("Georgia"));
    	  Thread.sleep(3000);
    		Assert.assertEquals(status.getText(), "Georgia");

    }
}
@Test(groups={"Search"})
public void SearchTestAnrealInfo() throws InterruptedException{
	HomePageObj hpo =new HomePageObj(driver);
    String array [] = {"Georgiya","Джорджия"};
    for(int i=0;i<=array.length-1;i++)
    {     hpo.getsearchF().clear();
    	hpo.getsearchF().sendKeys(array[i]);
    	hpo.getsearchB().click();
    	   Thread.sleep(3000);
    	   Assert.assertTrue(driver.findElement(By.cssSelector(".search-result-empty")).isDisplayed());
    	  Thread.sleep(3000);
    	  
    }
	System.out.println("Поиск ок");
}

@AfterClass
public void BrowserClose()

{

driver.close();
driver=null;

}

}