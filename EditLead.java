package testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {

	@Test(priority=1)
	public void editLead() throws InterruptedException {

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Parimala");		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Parimala']")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestCompanydef123");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		driver.findElement(By.id("viewLead_companyName_sp")).getTagName().contains("TestCompanyabc");

	}

}
