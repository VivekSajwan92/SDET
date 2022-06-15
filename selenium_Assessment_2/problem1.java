package selenium_Assessment_2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button")).click();
		
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("dashboard");
		
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.findElement(By.className("forceActionLink")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		WebElement a =driver.findElement(By.xpath("//*[@id='dashboardNameInput']"));
		a.click();
		a.sendKeys("Salesforce Automation Vivek Sajwan");
		driver.findElement(By.id("submitBtn")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText());
		
		
		driver.close();
		
		

	}

}
