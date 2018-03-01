package com.ibm.test1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class LoginTest 
{

	Logger logger=Logger.getLogger("LoginTest");
	
	WebDriver firefoxDriv;
	@BeforeTest
	public void beforeTest() 
	{
		  PropertyConfigurator.configure("log4j.properties");
		  System.setProperty("webdriver.gecko.driver", "C:/Softwares/Testing/Selenium Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		  firefoxDriv=new FirefoxDriver();
		  firefoxDriv.get("https://www.facebook.com/login/");
		  logger.info("url opened");
		  //firefoxDriv.manage().window().maximize();
		  logger.info("window maximized");
		  
  }
  @Test(priority=1)
  public void dataentry() throws InterruptedException 
  {
	  //username entering through textbox
	  firefoxDriv.findElement(By.xpath("//*[@id='email']")).sendKeys("8686254232");
	  logger.info("inserted username");
	//password through textbox
	  Thread.sleep(2000);
	  firefoxDriv.findElement(By.xpath("//*[@id='pass']")).sendKeys("srinivasan@");
	  logger.info("inserted password");
  }
  @Test(priority=2)
  public void submitButton()
  {
	//submit on button
	  firefoxDriv.findElement(By.xpath("//*[@id='loginbutton']")).click();
	  logger.info("data submitted by clicking on login");
	  firefoxDriv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
  }
  @Test(priority=3)
  public void postingOnWall()
  {
	//posting a message 
	  firefoxDriv.findElement(By.linkText("Compose Post")).click();
	  System.out.println("Hiiii.../.");
	  logger.info("Clicked on compose button");
	  firefoxDriv.findElement(By.xpath("//*[@name='xhpc_message']")).sendKeys("Good night  friends");
	  logger.info("typed the message");
	  firefoxDriv.findElement(By.xpath("//button[@data-testid='react-composer-post-button']")).click();
	  logger.info("posted");
	

  }
  @Test(priority=4)
  public void logout()
  {
	  //clicking on drop down box to logout
	  firefoxDriv.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
	  firefoxDriv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  firefoxDriv.findElement(By.linkText("Log out")).click();
	  logger.info("clicked on logout");
  }
  
  @AfterTest
  public void afterTest() 
  {
	  //closing the browser.
	  firefoxDriv.quit();
	  logger.info("Browser got quit");
  }

}
