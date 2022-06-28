package selenium_Assessment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem2 {

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
driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button")).click();
		
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("party consent");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("forceActionLink")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='uiInput uiInputText uiInput--default uiInput--input']//input")).sendKeys("Salesforce Automation Vivek Sajwan");
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
		driver.findElement(By.xpath("//span[text()='New Individual']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Vivek");
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Sajwan");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();
		
		WebElement ab = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText' and text()='Individual' and text()=' was created.']")); 
		if(ab.isDisplayed())
		{
			System.out.println("New Individual is created");
		}
		else 
		{
			System.out.println("New Individual is not created");
		}
		driver.findElement(By.xpath("(//div[@class='autocompleteWrapper slds-grow'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Business Brand']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input'])[3]//input")).sendKeys("BusinessBrand");
		driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input'])[4]//input")).sendKeys("1212");
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();
		WebElement abc = driver.findElement(By.xpath("//span[text()='Business Brand' and text()=' was created.']")); 
		if(abc.isDisplayed())
		{
			System.out.println("New Business is created");
		}
		else 
		{
			System.out.println("New Business is not created");
		}
		
		driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[4]")).click();
		driver.findElement(By.xpath("//*[@class='uiMenuItem uiRadioMenuItem']//*[text()='Email']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")).click();
		
		
		WebElement abcd = driver.findElement(By.xpath("//span[contains(text(),'Salesforce Automation Vivek Sajwan')]")); 
		
		if(abcd.isDisplayed())
		{
			System.out.println("Party Consent is created");
		}
		else 
		{
			System.out.println("Party Consent is not created");
		}
		driver.close();
		
	}

}
