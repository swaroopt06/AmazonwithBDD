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
import pomclass.SamsungProductsPage;

public class ValidateFilters {
	static {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
	}
	WebDriver driver;
	@Given("user is present in homepage")
	public void user_is_present_in_homepage() {
		System.out.println("User is present in Home page");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		HomePagePom h1= new HomePagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input")));
		h1.setPopup(); 
	}

	@When("user search for smartphones")
	public void user_search_for_smartphones() {
		System.out.println("User search for an Iphone");
		HomePagePom h1= new HomePagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		int i=50;
		while (i>0) {
			try {
				h1.setSearch("Samsung SmartPhones");
				break;
			} catch (Exception e) {
				
			}
		}
	  	}
	@And("user apply filters")
	public void user_apply_filters() {
		SamsungProductsPage p= new SamsungProductsPage(driver);
		p.setCheck();
	}

	@Then("validate filtered list")
	public void validate_filtered_list() {
		SamsungProductsPage p= new SamsungProductsPage(driver);
		Assert.assertFalse(p.setFiltered());
		System.out.println("Validate Filter list");
		driver.close();
	}
}
