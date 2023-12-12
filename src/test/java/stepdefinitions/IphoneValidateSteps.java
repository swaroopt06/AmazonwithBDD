package stepdefinitions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pomclass.CartPagePom;

import pomclass.HomePagePom;
import pomclass.ProductDetailsPagePom;

public class IphoneValidateSteps {
	static {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
	}
	WebDriver driver;
	
	
	@Given("user is on Home page")
	public void user_is_on_home_page() {
		System.out.println("User present in Home page");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		HomePagePom h1= new HomePagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input")));
		h1.setPopup();
	}

	@When("user searches Iphone")
	public void user_searches_iphone() throws InterruptedException {
		System.out.println("User search for an Iphone");
		HomePagePom h1= new HomePagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		int i=50;
		while (i>0) {
			try {
				h1.setSearch("Iphones");
				break;
			} catch (Exception e) {
				
			}
		}
		String iphone = h1.getIphone();
		String price = h1.getPrice();
		System.out.println("============================");
		System.out.println(iphone+"===>"+price);
		System.out.println("============================");
		h1.setclick();
		String phandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
	        if (!handle.equals(phandle)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	}

	@And("user add iphone to cart")
	public void user_add_iphone_to_cart() {
		System.out.println("User add Iphone to cart");
		ProductDetailsPagePom p= new ProductDetailsPagePom(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")));
		p.clickCart();
	}

	@Then("validate Iphone in cart")
	public void validate_iphone_in_cart() {
		System.out.println("Check whether same Iphone is present in cart or not");
		CartPagePom c= new CartPagePom(driver);
		Assert.assertTrue(c.isPresent());
		System.out.println("The Product is present in Cartpage");
		driver.close();
	}
}
