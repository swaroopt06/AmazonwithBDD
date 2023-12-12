package pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePom {
@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/a")
private WebElement product;

public CartPagePom(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public boolean isPresent() {
	return product.isDisplayed();
}

}
