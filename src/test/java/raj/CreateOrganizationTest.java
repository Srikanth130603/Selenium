package raj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(driver.getTitle().contains("vtiger CRM"))
			System.out.println("login page is displayed");
		else
			driver.quit();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if (driver.getTitle().contains("Home")) 
			System.out.println("Home page is displayed");
		else
			driver.quit();
		
		driver.findElement(By.xpath("//a[contains(@href,'Accounts&action=index')]")).click();
		
		if(driver.getTitle().contains("Organization"))
		    System.out.println("Organization page is displayed");
		else
			driver.quit();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		WebElement pageHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(pageHeader.isDisplayed())
			System.out.println("creating new organization page is displayed");
		else
			driver.quit();
		
		driver.findElement(By.name("accountname")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		
		//String newOrgPageHeader = driver.findElement(By.cssSelector(""));
		
		
	}

}
