package testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {

	@Test(priority=2,enabled=false)
	public void duplicateLead() throws InterruptedException {

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("parimalapawankumar@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Parimala")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Assert.assertEquals("Duplicate Lead | opentaps CRM", driver.getTitle());

		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.id("viewLead_firstName_sp")).getText().equals("Parimala");

	}

}
