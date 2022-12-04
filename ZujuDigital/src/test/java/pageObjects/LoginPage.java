package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Join Us')]")
	public WebElement joinUsButton;
	
	@FindBy(linkText = "Log In")
	public WebElement loginLink;
	
	@FindBy(xpath = "//h2[contains(text(),'Welcome to ZUJU KICKOFF')]/following::input[@name='email']")
	public WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordTextbox;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//h3[text()='Log Out']")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//h5[contains(text(),'Do you want to log out of this account?')]/following::button[text()='Log Out']")
	public WebElement logoutConfirmation;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
