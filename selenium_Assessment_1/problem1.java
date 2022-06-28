package selenium_Assessment_1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem1 {

	
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.redbus.in/");
			driver.findElement(By.xpath("//div[@class='fl search-box clearfix']//input")).sendKeys("Madiwala Bangalore");
			driver.findElement(By.xpath("//*[text()='Madiwala, Bangalore']")).click();
			
			driver.findElement(By.xpath("//div[@class='fl search-box']//input")).sendKeys("Koyambedu Chennai");
			driver.findElement(By.xpath("//*[text()='Koyambedu, Chennai']")).click();
			
			driver.findElement(By.xpath("//*[@class='rb-monthTable first last']//td[@class='wd day' and text()='30']")).click();
			driver.findElement(By.id("search_btn")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='dtAfter 6 pm']/parent::li//label[@class='custom-checkbox']")).click();
			driver.findElement(By.xpath("//input[@id='bt_SLEEPER']/parent::li//label[@class='custom-checkbox']")).click();
			driver.findElement(By.xpath("//div[@class='slick-track']//div")).click();
			String countbus=driver.findElement(By.xpath("//*[@class='f-bold busFound']")).getText();
			System.out.println(countbus);
			List<WebElement> fare=driver.findElements(By.xpath("//div[@class='fare d-block']//span"));
			for(WebElement web:fare)
			{
				String n=web.getText();
				System.out.println(n);
			}
			
			driver.findElement(By.xpath("//div[@class='sort-sec clearfix onward ']//*[text()='Fare']")).click();
		
driver.close();
		}

}
