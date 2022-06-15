package selenium_Assessment_2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class problem3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String price=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']")).click();	
		System.out.println(driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]//a[contains(@title,'5 stars')]")).getText());
		driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
	
		String parent1 = driver.getWindowHandle();
		Set<String> windowhandles2 = driver.getWindowHandles();
		List<String> childwind2= new ArrayList<String>(windowhandles2);
		
		driver.switchTo().window(childwind2.get(1));
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFileToDirectory(screenshot, new File("C:/Users/Vivek.Sajwan/eclipse-workspace/sdet-traning/src/test/java/selenium_Assessment_2/Screenshot"));
		 driver.findElement(By.id("submit.add-to-cart")).click();
		 Thread.sleep(3000);
		 //driver.switchTo().frame(0);
		 String total =driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		 Thread.sleep(2000);
		 System.out.println(total);
		 driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']")).click();
		
		 driver.findElement(By.id("continue")).click();
		 
		 String Error= driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
		 System.out.println(Error);
		 driver.close();
	}
}
