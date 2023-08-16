package Testlayer;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Baselayer.Baseclass;

public class Loginfunctionality extends Baseclass
{
	@BeforeClass
	public void setup()
	{
		Baseclass.initialization();
	}
	@Test(priority=1)
	public void loginfunctest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");;
		driver.findElement(By.xpath("//button[@type='submit']")).click();;
		
		
	}
	
	
	
	
}
