package raj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//loginscriptusing propertiesfile
public class Task1 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Data.properties");
		Properties pr=new Properties();
		pr.load(fis);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pr.getProperty("url"));
		
		long time =Long.parseLong(pr.getProperty("timeouts"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		driver.findElement(By.name("user_name")).sendKeys(pr.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pr.getProperty("password"));
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("login success");
		else
			System.out.println("login failed");
		
		driver.quit();
			
	}

}
