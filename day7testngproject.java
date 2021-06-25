package com.Launch;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class day7testngproject {
	static WebDriver driver;
  @Test(dataProvider = "getData1")
  public void s(String n, String s) throws IOException {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.id("txtUsername")).sendKeys(n);
	  driver.findElement(By.id("txtPassword")).sendKeys(s);
	  driver.findElement(By.id("btnLogin")).click();
	  NewTestM.screenshotPath();
	  
	  
	 
  }
  @Test(dataProvider = "getData2") 
  public void t(String sm,String ln) throws IOException{
	  driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
	  driver.findElement(By.id("menu_admin_UserManagement")).click();
	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys(sm);
	  WebElement opti = driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']"));
		Select proc = new Select(opti);
		//System.out.println("default option is " + proc.getFirstSelectedOption().getText());
		List<WebElement> pro = proc.getOptions();
		System.out.println("User Role is " +pro.size());
		proc.selectByVisibleText("Admin");
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(ln);
		NewTestM.screenshotPath();
		
	  
  }
  @DataProvider
  public Object[][] getData1() {
	  Object [] [] data = new Object[1] [2];
	  data[0][0] = "Admin";
	  data[0][1]= "admin123";
	  return data;
  }
  @DataProvider
  public Object[][] getData2() {
	  Object [] [] datas = new Object [1] [2];
	  datas[0][0]="Samruddhi shukla";
	  datas[0][1]="emp1";
	  return datas;
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\College\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.findElement(By.partialLinkText("Welcome")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.close();
  }

}
