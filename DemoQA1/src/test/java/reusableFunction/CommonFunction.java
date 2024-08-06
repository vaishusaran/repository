package reusableFunction;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonFunction {
	static WebDriver driver;
	public static void OpenBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumExe\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.linenchest.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	public static void Login(String sUsername, String sPassword) {
	driver.findElement(By.cssSelector(".dy-lb-close")).click();
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
	
	public static void BathNavigation() {
		driver.findElement(By.xpath("//div[@id='store.menu']/div[2]/ul/header/ul/li[2]/a/span")).click();
		
	}
	
	public static void CloseBrowser()
	{
		driver.close();
	}
	
	
}

