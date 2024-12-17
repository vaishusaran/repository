package LinenChest_Project.DemoQA1;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AddtoCart {
	
	public static void main(String[] args) throws InterruptedException 
	
	{
		 WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\seleniumExe\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.linenchest.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector(".dy-lb-close")).click();
		
		driver.findElement(By.xpath( "//div[@id='store.menu']/div[2]/ul/header/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("(//img[@alt='Royal Plush Bath Towel'])[2]")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(("window.scrollTo(0,406)"), "");
		driver.findElement(By.xpath("//div[@id='product-options-wrapper']/div/div/div/button")).click();
		driver.findElement(By.xpath("//div[@id='option-label-color-93-item-5739']/div")).click();
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']/span")).click();
		
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
				
	}



}
