package com.Launch;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
  @Test (dataProvider = "getData")
  public void Login(String n, String s,String fn,String ln) {
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	//Thread.Sleep(5000);
		
		driver.findElement(By.id("txtUsername")).sendKeys(n);
		driver.findElement(By.id("txtPassword")).sendKeys(s);
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fn);
		driver.findElement(By.id("lastName")).sendKeys(ln);
		driver.findElement(By.id("btnSave")).click();
		
		
}
 
  @DataProvider
	public Object [] [] getData()
	{
		Object [] [] data = new Object[1] [4];
		data[0][0] = "Admin";
		data[0][1]= "admin123";
		data[0][2]= "Seema";
		data[0][3]= "Mathews";
		
		//data[1][0] ="Admin";
		//data[1][1] ="admin123";
		
		//data[2][0]="Admin";
		//data[2][1]="admin123";
		
		//data[3][0]="Admin";
		//data[3][1]="admin123";
		
		return data;
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
