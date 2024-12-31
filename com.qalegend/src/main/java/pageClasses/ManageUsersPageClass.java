package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class ManageUsersPageClass{

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public ManageUsersPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[contains(text(),'Manage')]")
	WebElement manageUsersHeading;

	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement addButton;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirm_password;

	@FindBy(id = "submit_user_button")
	WebElement submit_user_button;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath = "//i[contains(@class,'glyphicon-edit')]")
	WebElement searchNameFilter;

	public String getTextOfManageUsersHeading() {

		return gl.getTextOfElement(manageUsersHeading);
	}

	public void addUserInManageUsers(String fnam, String mail, String uname, String pass, String confpass) {

		gl.clickOnElement(addButton);
		gl.typeOnElement(firstName, uname);
		gl.typeOnElement(email, mail);
		gl.typeOnElement(username, uname);
		gl.typeOnElement(password, pass);
		gl.typeOnElement(confirm_password, confpass);
		gl.clickOnElement(submit_user_button);
	}

	public void searchTheAddedUserInSearchBoxAfterAddition(String searchdata) {

		gl.typeOnElement(searchBox, searchdata);

	}

	public boolean isAddedUserDisplayedInSearch() {

		return gl.isElementDisplayed(searchNameFilter);

	}

}
