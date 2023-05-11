package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;

@RunWith(Cucumber.class)
public class gmailStepDefinition {
	
	Properties propertyManager;
	 public WebDriver driver;
	 public static FileInputStream fis;
	
	public WebDriver initiateBrowser() throws IOException
    {
    	String browserName = "Chrome";
    	if(browserName.equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");
			try{
				driver = new ChromeDriver();
			} catch(Exception e) {
				throw e;
			}
    	} else if (browserName.equalsIgnoreCase("edge")) {
    		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");
			try{
				driver = new ChromeDriver();
			} catch(Exception e) {
				throw e;
			}
    	}
    	driver.manage().window().maximize();
		return driver;    	
    }
	
	public void enterRecepient() {
		driver.findElement(By.xpath("//div[@class='aoD hl']")).sendKeys("krigupta2158@gmail.com");
	}
	
	public void enterSubject() {
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Incubyte");
	}
	
	public void enterBody() {
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Automation QA test for Incubyte");
	}
	
	@And("clicks send button")
	public void clickSend() {
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}	
	
	@Given("^browser is open$") 
	public void hello() throws IOException {
		driver = initiateBrowser();
	}
	
	@Given("user clicks compose button") 
	public void clickComposeBtn() {
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
	}
	
	@When("when the user enters composes the valid email")
	public void composeValidEmail() {
		 enterRecepient();
		 enterSubject();
		 enterBody();
	}
	
	@Then("the popup disappears")
	public void validatePopUpDisappears() {
		Boolean result = driver.findElement(By.xpath("(//div[@class='nH']//div[@role='dialog'])")).isEnabled();
		Assert.assertFalse(result);
	}
	
	@Given("gmail is opened")
	public void basicLogin() {
		driver.get("https://www.gmail.com/");
	}
	
	@When("the user is logs in")
	public void uid_password() {		
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("krigupta2158@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Potest100!");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	@Then("successful login")
	public void successful_login() {
		System.out.println("Verified successful login.");
	}
}
