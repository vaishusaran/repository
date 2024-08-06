package LinenChest_Project.DemoQA1;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;


public class FirstTest {
public static void main (String args []) throws InterruptedException, BiffException, IOException
{
	LinenChestSignin Lsn = new LinenChestSignin();
// Browser setup
System.setProperty("webdriver.chrome.driver","C:\\seleniumExe\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();

// Open URL
driver.get("https://www.linenchest.com");
driver.manage().window().maximize();
Thread.sleep(10000);

//if(!driver.findElement(By.id("saveBtn-18434555")).isDisplayed())
	driver.findElement(By.cssSelector(".dy-lb-close")).click();
//Validate The Page Title
String actualTitle=driver.getTitle();
String expectedTitle ="Linen Chest | Your Bedding, Home Decor, Kitchen & Bath Store";
assertEquals(expectedTitle,actualTitle);
System.out.println("Actual Title is:"+actualTitle);
//System.out.println("Actual Title is: &actualTitle);


//click signin

Lsn.Signin(driver);

//driver.close();
}


}
