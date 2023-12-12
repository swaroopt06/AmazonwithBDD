package pomclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom{
@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div")
private WebElement lgnbtn;

@FindBy(xpath="/html/body/div[3]/div/span")
private WebElement popup;

@FindBy(name="q")	
private WebElement srchbx;

@FindBy(xpath="//div[contains(text(),'APPLE iPhone')]")
private WebElement iphone;

@FindBy(xpath="(//div[contains(text(),'APPLE iPhone')]/../../div[2]/div/div/div[1])[1]")
private WebElement price;

@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]")
private WebElement click;

public void setPopup() {
	popup.click();
}
public HomePagePom(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void setSearch(String str) {
	srchbx.sendKeys(str+Keys.ENTER);
	
}
public String getIphone() {
	return	iphone.getText();

}
public String getPrice() {
	return price.getText();
	
}
public void setclick() {
	click.click();
}
public void clickLogin() {
	lgnbtn.click();
}

}
