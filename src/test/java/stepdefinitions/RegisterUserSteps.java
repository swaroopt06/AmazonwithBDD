package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomclass.HomePagePom;
import pomclass.LoginPagePom;
import pomclass.SignUpPom;

public class RegisterUserSteps {
	static {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
	}
	WebDriver driver;	
	@Given("user is in homepage")
	public void user_is_in_homepage() {
	 System.out.println("User is in home page");
	 driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		HomePagePom h1= new HomePagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input")));
		h1.setPopup();
	}

	@When("user clicks on login")
	public void user_clicks_on_login() {
	 System.out.println("User clicks on login button");
	 HomePagePom h1= new HomePagePom(driver);
	 h1.clickLogin();
	}

	@Then("user clicks on Create New Account")
	public void user_clicks_on_create_new_account() {
	  System.out.println("User clicks on create new account"); 
	  LoginPagePom l= new LoginPagePom(driver);
	  l.clickNewUser();

	}

	@And("user enters phone number")
	public void user_enters_phone_number() {
	   System.out.println("User enters phone number");
	   SignUpPom s= new SignUpPom(driver);
	   s.setNum("9876543210");
	}

	@Then("user clicks on requestOTP")
	public void user_clicks_on_request_otp() throws InterruptedException {
	   System.out.println("User clicks on Request OTP");
	   SignUpPom s= new SignUpPom(driver);
	   s.clickReg();
	   s.setOtp("123456");
	  Assert.assertTrue(s.getTry());
	  driver.close();
	}
}
