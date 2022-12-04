package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ReputationPage;
import util.ConfigFileReader;

public class ZujuDigital {

	public static WebDriver driver;
	LoginPage loginPageObject;
	ReputationPage reputationPageObject;
	ConfigFileReader configFileReader;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@Given("I navigate to ZujuDigital Reputation page")
	public void i_navigate_to_zuju_digital_reputation_page() {
		configFileReader = new ConfigFileReader();
		reputationPageObject = new ReputationPage(driver);
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().window().maximize();
		String pageHeader = reputationPageObject.pageHeader.getText();
		System.out.println(pageHeader);
		Assert.assertEquals(pageHeader, "All Teams");
	}

	@When("I login and search for {string} and add as Favourite")
	public void i_login_and_search_for_and_add_as_favourite(String city) {
		loginPageObject = new LoginPage(driver);
		reputationPageObject = new ReputationPage(driver);
		loginPageObject.joinUsButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		loginPageObject.loginLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginPageObject.loginButton));
		try {
			loginPageObject.emailTextbox.sendKeys(configFileReader.getUserName());

		} catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			loginPageObject.emailTextbox.sendKeys(configFileReader.getUserName());

		}
		loginPageObject.passwordTextbox.sendKeys(configFileReader.getPassword());
		loginPageObject.loginButton.click();
		Assert.assertTrue(reputationPageObject.pageHeaderAfterLogin.isDisplayed());
		reputationPageObject.searchTextBox.sendKeys(city);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		reputationPageObject.favoriteIcon.click();
		}

	@Then("I logout from site")
	public void i_logout_from_site() {
		loginPageObject = new LoginPage(driver);
		reputationPageObject = new ReputationPage(driver);
		reputationPageObject.settingButton.click();
		loginPageObject.logoutButton.click();
		loginPageObject.logoutConfirmation.click();
		}

	@After
	public void tearDown() {
		driver.quit();
	}

}
