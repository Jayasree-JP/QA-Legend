package testClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyser.RetryAnalyserClass;
import utilityClasses.Constants;
import utilityClasses.ExcelReadClass;
import utilityClasses.GeneralUtilities;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 4, retryAnalyzer = RetryAnalyserClass.class, groups = {"functional"})
	public void verifySuccessfullLogin() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));  //reading data from excelread utility by giving correct row and col
		//hp = lp.login(Constants.username, Constants.password);
		hp.clickOnEndTour();
		String actualRes = hp.getTextOfWelcomeAdmin();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(4, 0)));
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyserClass.class)
	public void verifyTheRememberMeCheckboxIsSelectedByDefault() {

		lp = new LoginPageClass(driver);
		boolean actualRes = lp.checkRememberMeCheckBoxSelected();
		Assert.assertFalse(actualRes, "The check box is selected");
	}

	@Test(priority = 3, dataProviderClass = LoginPageTestUnsuccessfullData.class, dataProvider = "UnsuccessfullLogin", retryAnalyzer = RetryAnalyserClass.class)
	public void verifyUnsuccessfulLoginOfTheSite(String uname, String pass) {

		lp = new LoginPageClass(driver);
		hp = lp.login(uname, pass);
		String actualRes = lp.getTextOfUnSuccessfullLogin();
		Assert.assertTrue(actualRes.contains("credentials do not"));
	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyserClass.class)
	public void verifyTheExactURL_OpensWhileHittingTheBaseURL() {

		lp = new LoginPageClass(driver);
		String actualRes = lp.getCurrentUrlOfThePage();
		String expectedRes = "https://qalegend.com/billing/public/login";
		Assert.assertEquals(actualRes, expectedRes);
	}

	@Test(priority = 5, retryAnalyzer = RetryAnalyserClass.class)
	public void verifyResetPasswordPageComingWhileChickingOnForgotYourPassword() {

		lp = new LoginPageClass(driver);
		lp.clickOnForgotYourPasswordLink();
		String actualRes = lp.getTextOfResetPasswordMsg();
		Assert.assertTrue(actualRes.contains("Reset"));
	}
	

}
