package selenium_Assessment_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem2 {

	public static void main(String[] args) throws InterruptedException, ParseException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(6000);
		WebElement toogle = driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button"));
		Actions action = new Actions(driver);
		action.click(toogle).perform();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//*[@class='slds-truncate' and text()='Content']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='narrow homeHomeCard runtime_sales_activitiesTodayTaskContainer']//a[@class='viewAllLink']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']")).click();
		driver.findElement(By.xpath("//*[text()='Table']")).click();
		Thread.sleep(2000);
		
		WebElement drop = driver.findElement(By.xpath("//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']"));
		Actions action1 = new Actions(driver);		
		action1.click(drop).perform();
		
		WebElement Follow=driver.findElement(By.xpath("//div[@class='forceActionLink' and  text()='Create Follow-Up Task']"));
		driver.executeScript("arguments[0].click()", Follow);
		WebElement subject =driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input slds-combobox__input-value'])[2]"));
		subject.click();
		subject.sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
		
		subject.sendKeys("Meeting");
		
		driver.findElement(By.xpath("(//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='primaryLabel slds-truncate slds-lookup__result-text'])[2]")).click();
		
		String requiredDate = "5-07-2022";
		String Date = requiredDate.split("-")[0];
		String Month = requiredDate.split("-")[1];
		String Year = requiredDate.split("-")[2];
		
		int monthToSelect = Integer.parseInt(Month);
		
		driver.findElement(By.xpath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click slds-size_1-of-1']")).click();
		String aMonth = driver.findElement(By.xpath("//*[@class='slds-align-middle' and contains(@id,'month-title')]")).getText();
		
		
		SimpleDateFormat input = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		cal.setTime(input.parse(aMonth));
		
		SimpleDateFormat output = new SimpleDateFormat("MM");
		int currentMonth = Integer.parseInt(output.format(cal.getTime()));
		if (monthToSelect > currentMonth) {
			for (int i = 0; i < monthToSelect - currentMonth; i++) {
				driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container' and @title='Next Month']")).click();
			}
		} // to click the previous months
		else if (monthToSelect < currentMonth) {

			for (int i = 0; i < currentMonth - monthToSelect; i++) {
				driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container' and @title='Previous Month']")).click();
			}
		}
		
		try {
		List<WebElement> clickableDate = driver.findElements(By.xpath("//tr//*[@class='slds-day']"));
		for (WebElement date : clickableDate) {
			
			String text = date.getText();
			if(Date.equals(text)) {
				date.click();
			
		}
			
		}
		}
		catch(Exception e){
		    }
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")).click();
		
		if(driver.findElement(By.xpath("//*[text()='Task' and text()=' was created.']//*[text()='Meeting']")).isDisplayed())
		{
			System.out.println("Task Created");
		}
		else {
			System.out.println("Task Not Created");
			
		}
driver.close();		
		
		
	}}