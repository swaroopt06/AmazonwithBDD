package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPagePom {
@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")	
private WebElement cart;

public ProductDetailsPagePom(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickCart() {
	cart.click();
}
}
