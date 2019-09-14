package SeleniumUI;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*1.	Go to https://www.loblaws.ca
2.	Click on MY SHOP tab
3.	Click on green sign in button
4.	Click on “Create a PC id”
5.	Fill in the details in the form
6.	Verify test “Complete your profile” appears*/

public class CreatePCId {
	
	public WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.loblaws.ca");
		//driver.manage().window().maximize();
	

	}
	@Test
	//public WebDriver driver;
	public void createPC() {
		System.out.println("hi");
        driver.findElement(By.className("primary-nav__list__item__link__text")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.cssSelector(".quick-shop-anonymous-content__login-button > span:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign In")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/a")).click();
		WebElement email=driver.findElement(By.id("email"));
		WebElement Password = driver.findElement(By.id("newPassword"));
		email.sendKeys("HelloPC@gmail.com");
		Password.sendKeys("Garden$3019");
        js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.className("checkbox-group__icon")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/fieldset/button")).click();
		String profilecomplete = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/fieldset/button")).getText();
		Assert.assertEquals(profilecomplete, "Complete Your Profile");
	}
}
