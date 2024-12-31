package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class LoginPageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public LoginPageClass(WebDriver driver) { // pageclass driver and baseclass driver is same.To tell that we are using
												// constructor..

		this.driver = driver;
		PageFactory.initElements(driver, this); // by giving this we don't need to give findElement code from now..
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//strong[contains(text(),'credentials')]") // xpath= //*[@class='help-block']/child::strong
	WebElement unsuccessLoginMsg;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//a[contains(@class,'btn-link')]")
	WebElement forgotYourPassLink;
	
	@FindBy(xpath = "//div[@class='panel-heading']")
	WebElement resetPasswordMsg;

	public HomePageClass login(String uname, String pass) {

		gl.typeOnElement(username, uname);
		gl.typeOnElement(password, pass);
		gl.clickOnElement(loginButton);

		return new HomePageClass(driver); // here as we gone some other page after login give this way...
	}

	public String getTextOfUnSuccessfullLogin() {

		return gl.getTextOfElement(unsuccessLoginMsg);
	}

	public boolean checkRememberMeCheckBoxSelected() {

		return gl.isElementSelected(rememberMeCheckBox);
	}

	public String getCurrentUrlOfThePage() {

		return gl.getCurrentUrl(driver);
	}
	public void clickOnForgotYourPasswordLink() {

		gl.clickOnElement(forgotYourPassLink);
	}
	public String getTextOfResetPasswordMsg() {

		return gl.getTextOfElement(resetPasswordMsg);
	}
	

}
