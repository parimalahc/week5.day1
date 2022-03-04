package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident extends BaseClass{
	
	@Test(priority=4,invocationCount = 3,threadPoolSize = 2)
	public void createIncident() {
		driver.findElement(By.id("filter")).sendKeys("incident" + Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.linkText("survey user")).click();
		driver.switchTo().window(windows.get(0));
		driver.switchTo().frame("gsft_main");
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident number is: " + incidentNumber);
		driver.findElement(By.id("incident.short_description")).sendKeys("Hi I am a survey user");		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
				.sendKeys(incidentNumber + Keys.ENTER);
		driver.findElement(By.linkText(incidentNumber)).click();
	}

}
