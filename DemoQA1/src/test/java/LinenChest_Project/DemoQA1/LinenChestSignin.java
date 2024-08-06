package LinenChest_Project.DemoQA1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException; 


public class LinenChestSignin extends FirstTest{
		
	
	SigninInExcel readd = new SigninInExcel();
	public void Signin(WebDriver driver) throws BiffException, IOException{
		// TODO Auto-generated method stub
		String usernamee=SigninInExcel.readXl(0,1);
		System.out.println(usernamee);
		String passwordd=SigninInExcel.readXl(1,1);
		System.out.println(passwordd);
		
		driver.findElement(By.cssSelector(".customer-icon")).click();
		driver.findElement(By.cssSelector(".sign-in")).click();
		WebElement username=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("pass"));
		WebElement login=driver.findElement(By.cssSelector(".primary:nth-child(3) span"));
		username.sendKeys(usernamee);
		password.sendKeys(passwordd);
		login.click();
	}

}
