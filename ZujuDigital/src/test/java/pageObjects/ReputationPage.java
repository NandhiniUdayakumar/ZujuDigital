package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReputationPage {
	

	public ReputationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[contains(text(),'All Teams')]")
	public WebElement pageHeader;
	
	@FindBy(xpath = "//h2[contains(text(),'Favourite Teams')]")
	public WebElement pageHeaderAfterLogin;
	
	@FindBy(xpath = "//h3[contains(text(),'View your loyalty points across each team')]/following::input[@type='search']")
	public WebElement searchTextBox;
	
	@FindBy(xpath = "//p[contains(text(),'Manchester City')]//preceding::button[@aria-label='favorite']")
	public WebElement favoriteIcon;
	
	@FindBy(xpath = "//div[@id='settings-option']/button[@data-cy='settings-btn']")
	public WebElement settingButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
