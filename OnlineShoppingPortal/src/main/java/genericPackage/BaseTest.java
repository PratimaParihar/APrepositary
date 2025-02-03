package genericPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class BaseTest extends Flib implements IAutoConstant {
	
	public WebDriver wdriver; 
	public static WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	public void browserSetUp() throws IOException, InterruptedException
	{
		Flib flib = new Flib();
		String browser = flib.readPropertyData(PROP_PATH, "browser1");
		String url = flib.readPropertyData(PROP_PATH, "url");
			
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter Valid Browser Name");
		}
		wdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Thread.sleep(1000);
	}
	
	public void failedMethodSs(String failedMethodName) 
	{
		
		String dateTime = LocalDateTime.now().toString();
		String newdateTime = dateTime.replaceAll(":", "-");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(SCRRENSHOTS + failedMethodName+newdateTime+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@AfterMethod(alwaysRun = true)
public void browserTearDown() throws InterruptedException
{
		Thread.sleep(1000);
		driver.quit();
}
}
