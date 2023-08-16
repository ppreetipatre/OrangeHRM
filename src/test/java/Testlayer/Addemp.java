package Testlayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baselayer.Baseclass;
import Utilitylayer.Excelreader;

public class Addemp extends Baseclass {
	@Test(priority = 2, dataProvider = "getcontactdata")
	public void addemptest(String fname, String mname, String lname,String empid) throws InterruptedException {
		System.out.println("hello");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("middleName")).sendKeys(mname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		WebElement wb = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		wb.sendKeys(empid);
		String empid1 = wb.getAttribute(empid);
		System.out.println(empid1);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@DataProvider
	public Object getcontactdata() throws IOException {
		Excelreader obj = new Excelreader(
				"C:\\Users\\18134\\eclipse-workspace\\Orangehrm\\src\\main\\java\\Testdata\\orangehumdata.xlsx");
		// System.getProperty ("user.dir") +
		// "src\\main\\java\\Testdata\\orangehumdata.xlsx");
		Object data = obj.getallsheetdata(0);
		return data;
	}

}
