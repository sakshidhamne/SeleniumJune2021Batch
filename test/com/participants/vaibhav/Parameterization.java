package com.persistent.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Parameterization {
	WebDriver driver;
	@Parameters ({"suite-param"})
  @Test
  public void f(String param) throws IOException {
		driver.get(PropertyReader.getProperties("baseURL"));
		driver.findElement(By.name("q")).sendKeys(param);
		driver.findElement(By.name("btnK")).submit();
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
