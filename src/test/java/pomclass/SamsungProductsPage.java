package pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungProductsPage {
@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[7]/div[2]/div/div[1]/div/label/div[1]")
private WebElement check4; 

@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]/ul/li[1]")
private List<WebElement> filter;

public SamsungProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void setCheck() {
	check4.click();
}

public boolean setFiltered() {
	boolean status = filter.contains("4 GB RAM");
	return status;
}

}
