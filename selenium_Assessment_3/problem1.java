package selenium_Assessment_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[name()='svg' and @class='slds-icon slds-icon_x-small']//ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='New Task']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
		driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
		driver.findElement(By.xpath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//div[@class='uiPopupTrigger']//a")).click();
		driver.findElement(By.xpath("//*[text()='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
		if(driver.findElement(By.xpath("//*[text()='Task' and text()=' was created.']//*[text()='Bootcamp']")).isDisplayed())
		{
			System.out.println("Task Created");
		}
		else {
			System.out.println("Task Not Created");
			
		}
driver.close();		
		
		
		
	}

}
