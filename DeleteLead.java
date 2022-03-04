package testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {
	
    @Test
	public void deleteLead() throws InterruptedException {

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("9884456565");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		driver.findElement(By.linkText("Parimala")).click();
		driver.findElement(By.linkText("Delete")).click();

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys("11773");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='No records to display']")).isDisplayed();
		driver.close();

	}

}
