package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClass{
	
	@Test(priority=3,enabled=false)
	public void updateIncident() {
		driver.findElement(By.id("filter")).sendKeys("incident" + Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
				.sendKeys("INC0010012" + Keys.ENTER);
		driver.findElement(By.linkText("INC0010012")).click();
		
		Select urgencySelect = new Select(driver.findElement(By.id("incident.urgency")));
		urgencySelect.selectByVisibleText("1 - High");
		
		Select stateSelect = new Select(driver.findElement(By.id("incident.state")));
		stateSelect.selectByVisibleText("In Progress");
		
		driver.findElement(By.id("sysverb_update")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'row_incident')]/td[7]")).getText(), "3 - Moderate");
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'row_incident')]/td[8]")).getText(), "In Progress");
	}

}
