package scipts.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;


public class Node1CH {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	
	
  @Test
  public void Test() throws InterruptedException, IOException, AWTException {
	 
		DesiredCapabilities  dr=DesiredCapabilities.chrome();
        //set browser name
		 dr.setBrowserName("chrome");
        //set platform as windows
        dr.setPlatform(Platform.WINDOWS);
        
//using the RemoteWebDriver object
RemoteWebDriver driver=new RemoteWebDriver(new    URL("http://192.168.237.1:4444/wd/hub"), dr);
driver.manage().window().maximize();
driver.navigate().to("https://yahoo.com");
Thread.sleep(2000);
	
driver.findElement(By.id("login-username")).clear();
driver.findElement(By.id("login-username")).sendKeys("abc");
driver.findElement(By.id("login-signin")).click();
Thread.sleep(5000);	
driver.findElement(By.id("login-passwd")).clear();
driver.findElement(By.id("login-passwd")).sendKeys("efg");
driver.findElement(By.id("login-signin")).click();
        driver.close();
  }
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DiverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DiverPath);
		driver=new ChromeDriver();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
