package HardcodeData;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DatepickerHandling {

	public static void main(String[] args) {
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
		
		WebElement quickcreateDD=driver.findElement(By.id("qccombo"));
		Select select=new Select(quickcreateDD);
		select .selectByValue("Events");
		
		driver.findElement(By.name("subject")).sendKeys("Event1");
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		
		int reqStartyear=2028;
		String reqStartDate="9";
		String reqStartMonth="January";
		
		String currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[@class='title']")).getText();
		String[] str=currentMonthYear.split(", ");
		int currentYear=Integer.parseInt(str[1]);
		
		while(currentYear<reqStartyear)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[text()='»']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentYear=Integer.parseInt(str[1]);
			
		}
		int currentmonth= DateTimeFormatter
								.ofPattern("MMMM")
								.withLocale(Locale.ENGLISH)
								.parse(str[0])
								.get(ChronoField.MONTH_OF_YEAR);
		
		int reqstartMonthinNum= DateTimeFormatter
				
								.ofPattern("MMMM")
								.withLocale(Locale.ENGLISH)
								.parse(reqStartMonth)
								.get(ChronoField.MONTH_OF_YEAR);
		while(currentmonth<reqstartMonthinNum)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[text()='›']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentmonth= DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);	
		}
		while(currentmonth>reqstartMonthinNum)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[text()='‹']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(style,block)]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentmonth= DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);	
		}
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='"+reqStartDate+"']")).click();
		driver.findElement(By.id("jscal_trigger_due_date")).click();
		
		int reqEndYear=2028;
		String reqEndDate="9";
		String reqEndMonth="June";
		
		currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		str = currentMonthYear.split(", ");
		currentYear = Integer.parseInt(str[1]);						
		
		while(currentYear<reqEndYear)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentYear = Integer.parseInt(str[1]);
			
		}
		
		currentmonth=DateTimeFormatter
							.ofPattern("MMMM")
							.withLocale(Locale.ENGLISH)
							.parse(str[0])
							.get(ChronoField.MONTH_OF_YEAR);
		int reqEndofMonthInNum= DateTimeFormatter
							.ofPattern("MMMM")
							.withLocale(Locale.ENGLISH)
							.parse(reqEndMonth)
							.get(ChronoField.MONTH_OF_YEAR);
		while(currentmonth<reqEndofMonthInNum)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='›']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentmonth=DateTimeFormatter
							.ofPattern("MMMM")
							.withLocale(Locale.ENGLISH)
							.parse(str[0])
							.get(ChronoField.MONTH_OF_YEAR);
		}
		while(currentmonth>reqEndofMonthInNum)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='‹']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentmonth=DateTimeFormatter
						.ofPattern("MMMM")
						.withLocale(Locale.ENGLISH)
						.parse(str[0])
						.get(ChronoField.MONTH_OF_YEAR);
					
		}
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='"+reqEndDate+"']")).click();
		driver.findElement(By.xpath("//input[@value='  Save']")).click();
		WebElement adminWidget=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(adminWidget).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
