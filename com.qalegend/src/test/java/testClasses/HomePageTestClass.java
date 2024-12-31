package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import retryAnalyser.RetryAnalyserClass;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass up;

	@Test
	public void verifyAllTilesDisplayedOnHomePage() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		boolean actualRes = hp.isAllTilesDisplayed();
		Assert.assertTrue(actualRes);

	}

	@Test
	public void verifyTheTooltip_Calculator_isShowingWhileHoveringTheMouseOnCalculator() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.hoverTheMouseOnCalculator();
		String actualRes = hp.getAttributeValueOfTitleOfCalculator("data-original-title");
		String expectedRes = "Calculator";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualRes, expectedRes, "Not Successfull");
		soft.assertAll();

	}
	@Test(groups = {"functional"})
	public void verifySuccessfulSignOut() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		lp = hp.signOutFromHomePage();
		String actualRes = hp.getTextOfDemo_POSHeadingInLoginPage();
		String expectedRes = "Demo POS";
		Assert.assertEquals(actualRes, expectedRes);
		System.out.println("Signed Out Successfully!!!");
		
	}	

}
