package reusableFunction;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {
	static WebDriver driver;
	public static void OpenBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumExe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized", "--headless", "--window-size=2560,1440","--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage");
    	options.addArguments("--log-level=3");
    	driver = new ChromeDriver(options);
		driver.get("https://www.linenchest.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	public static void modalClose() {
		// Closing pop up window
		driver.findElement(By.cssSelector(".dy-lb-close")).click();
	}
	
	public static void Login(String sUsername, String sPassword) {
	//Validate The Page Title
	String actualTitle=driver.getTitle();
	String expectedTitle ="Linen Chest | Your Bedding, Home Decor, Kitchen & Bath Store";
	assertEquals(expectedTitle,actualTitle);
	System.out.println("Actual Title is:"+actualTitle);
	driver.findElement(By.cssSelector(".customer-icon")).click();
	driver.findElement(By.cssSelector(".sign-in")).click();
	//WebElement username=driver.findElement(By.id("email"));
	//WebElement password=driver.findElement(By.id("pass"));
	driver.findElement(By.id("email")).sendKeys(sUsername);
	driver.findElement(By.id("pass")).sendKeys(sPassword);
	WebElement login=driver.findElement(By.cssSelector(".primary:nth-child(3) span"));
	login.click();
	}
	
	public static void productNavigation() throws InterruptedException {
		//
		driver.findElement(By.xpath( "//div[@id='store.menu']/div[2]/ul/header/ul/li[2]/a/span")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Royal Plush Bath Towel'])[2]")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(("window.scrollTo(0,406)"), "");
		driver.findElement(By.cssSelector(".swatch-opt .button")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#offCanvas-color #option-label-color-93-item-5739 > .image-container"))).click();
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']/span")).click();
	}
	
	public static void productSearch() {
		driver.findElement(By.id("search")).click();
		driver.findElement(By.id("search")).sendKeys("towel");
		driver.findElement(By.cssSelector(".algolia-confirm-query")).click();
		driver.findElement(By.xpath("//li[2]/a/div/div[2]/h3/mark")).click();
	}
	
	public static void CloseBrowser()
	{
		driver.close();
	}
	
	
}

