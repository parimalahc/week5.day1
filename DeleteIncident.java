package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClass{

	@Test(priority=2)
	public void deleteIncident() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident" + Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
				.sendKeys("INC0010016" + Keys.ENTER);
		driver.findElement(By.linkText("INC0010016")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Search']//following::input[1]"))
				.sendKeys("INC0010016" + Keys.ENTER);

		if (driver.findElements(By.xpath("//a[text()='INC0010016']")).size() > 0) {
			System.out.println("Incident is not deleted");
		} else {
			System.out.println("Incident is deleted");
		}

	}

}
