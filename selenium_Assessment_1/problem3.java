package selenium_Assessment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem3 {
	public static void main(String[] args) throws InterruptedException {

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://login.salesforce.com");
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password@123");
	driver.findElement(By.id("Login")).click();
	
	Thread.sleep(3000);
driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button")).click();
	
	driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("party consent");
	driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']//input")).sendKeys("Vivek Sajwan",Keys.ENTER);
	Thread.sleep(100);
	driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();
	driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
	driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();

	Boolean b= driver.findElement(By.xpath("//span[contains(text(),'Salesforce Automation Vivek Sajwan')]")).isDisplayed();

	if(!b)
	{
		System.out.println("Party Consent is Deleted");
	}
	else 
	{
		System.out.println("Party Consent is not Deleted");
	}
	driver.close();
}
	
}
