package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import retryAnalyser.RetryAnalyserClass;
import utilityClasses.RandomDataUtility;

public class ManageUsersPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass up;
	
	@Test
	public void verifyTheManageUsersPageIsOpenWhileClickingOnUsers() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickUserManagementBtnInHomePage();
		up = hp.clickOnUsersOptionUnderUserMngmt();
		String actualRes = up.getTextOfManageUsersHeading();
		Assert.assertTrue(actualRes.contains("Manage"));

	}

	@Test(groups = {"functional"})
	public void verifyToAdd_aNewUser() {
		
		String newusername = RandomDataUtility.getUserFullName();   //to check assertions as same as random name
		String password = RandomDataUtility.getPassword();
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickUserManagementBtnInHomePage();
		up = hp.clickOnUsersOptionUnderUserMngmt();
		up.addUserInManageUsers(newusername, RandomDataUtility.getRandomEmail(), newusername, password, password);
		up.searchTheAddedUserInSearchBoxAfterAddition(newusername);
		boolean actualRes = up.isAddedUserDisplayedInSearch();
		Assert.assertTrue(actualRes);
		System.out.println("User added successfully!!!");
	}

}
