package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePom {
@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[4]/a")
private WebElement newUser;

public LoginPagePom(WebDriver driver) {
	PageFactory.initElements(driver,this);
} 

public void clickNewUser() {
	newUser.click();
}
}
