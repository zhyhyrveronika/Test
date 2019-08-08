package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import pageObjects.HomePageObj;
import resources.info;

public class Tests extends info{
	
	@BeforeSuite
	public void init() throws IOException{
		driver=IntialDr();
		driver.manage().window().maximize();
	    System.out.println("The profile setup process is completed");
		
	}
	
	@BeforeTest
	public void appSetuppp() throws InterruptedException {
		driver.get("https://misteram.com.ua/chernigov");
        driver.findElement(By.linkText("Peperoni")).click();
		driver.findElement(By.cssSelector("div.dish:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > i:nth-child(1)")).click();
	   	 Thread.sleep(3000);
	   	driver.findElement(By.cssSelector("div.dish:nth-child(7) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > i:nth-child(1)")).click();
	   	 Thread.sleep(3000);
	   	Assert.assertTrue(driver.findElement(By.cssSelector(".meals-btn > a:nth-child(1) > button:nth-child(1)")).isDisplayed()); 
	    System.out.println("корзина есть! ");
		}
	
	
	@Test
	public void checkCart() throws InterruptedException{
	   	
	driver.findElement(By.cssSelector(".meals-btn > a:nth-child(1) > button:nth-child(1)")).click();
	Thread.sleep(3000);
	Assert.assertFalse(driver.findElement(By.cssSelector("div.empty-cart:nth-child(2")).isDisplayed()); 
	 System.out.println("Товары добавлены/Корзина не пустая ");
	
		
	//}
	//@Test
	//public void cancelDelete() throws InterruptedException{
		driver.findElement(By.cssSelector("div.title:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div[3]/div[1]")).click();
		Thread.sleep(3000);
		Assert.assertFalse(driver.findElement(By.cssSelector("div.empty-cart:nth-child(2")).isDisplayed()); 
		 System.out.println("Товары не удалились ");

	
	}
	
	@Test
	public void confirmCheckout() throws InterruptedException{
		driver.findElement(By.cssSelector("div.button-order:nth-child(1)")).click();
		driver.findElement(By.id("submitCheckForm")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div[1]")).isDisplayed());
		System.out.println("проверка на пустые поля - ок");
		driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div[3]/div")).click();
	}
	
	@Test
	public void deleteFuncInCart() throws InterruptedException{
		driver.get("https://misteram.com.ua/chernigov/cart");
		driver.findElement(By.cssSelector("div.title:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".close")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.cssSelector("div.empty-cart:nth-child(2")).isDisplayed()); 
	     System.out.println("Товары  удалены");
	}	
	@AfterTest
	public void BrowserClose()
	{

	driver.close();
	driver=null;

	}

}


