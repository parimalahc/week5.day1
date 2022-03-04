package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClass{
	
	@Test(priority=1)
	public void assignIncident() {
		driver.findElement(By.id("filter")).sendKeys("incident" + Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
				.sendKeys("INC0010012" + Keys.ENTER);
		driver.findElement(By.linkText("INC0010012")).click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
		.sendKeys("software" + Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(windows.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Hi I am updating work notes");
		driver.findElement(By.id("sysverb_update")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'row_incident')]/td[10]")).getText(), "Software");
	}

}
