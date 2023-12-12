package pomclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPom {
	
@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")
private WebElement txtbx;

@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")
private WebElement register;

@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/input")
private WebElement otp;

@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/span[2]")
private WebElement attempt;

public SignUpPom(WebDriver driver) {
	PageFactory.initElements(driver,this);
} 

public void setNum(String num) {
	txtbx.sendKeys(num+Keys.ENTER);
}

public void clickReg() {
	register.click();
}
public void setOtp(String text) {
	otp.sendKeys(text+Keys.ENTER);
}

public boolean getTry() {
	 return attempt.isDisplayed();
}

}