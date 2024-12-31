package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import pageClasses.ProductsPageClass;
import retryAnalyser.RetryAnalyserClass;

public class ProductsPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass up;
	ProductsPageClass pp;

	@Test
	public void verifyProductsPageIsOpenWhileClickingOnListProducts() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		pp = hp.clickOnListProductsBtnUnderProducts();
		String actualRes = pp.getTextOfManageProductsHeading();
		Assert.assertTrue(actualRes.contains("Manage"));

	}

	@Test(groups = {"functional"})
	public void verifyToCreateA_newProduct() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		pp = hp.clickOnListProductsBtnUnderProducts();
		pp.addProductInManageProducts("Product-1", "8", System.getProperty("user.dir")+"\\src\\test\\resources\\nms.png", "10",
				"50");   //Here we first copy and pasted the image from system to src/test/resources and copy its path and then use this way as easy for github and can access everyone...
		pp.searchTheAddedProductInSearchBox("Product-1");
		String actualRes = pp.getTextOfNameFieldOfProductAfterSearch();
		String expectedRes = "Product-1";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualRes, expectedRes, "Product not added successfully!!!");
		soft.assertAll();
		System.out.println("Product added successfully!!!");
	}

	@Test(groups = {"functional"})
	public void verifyToDeleteAddedProduct() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		pp = hp.clickOnListProductsBtnUnderProducts();
		pp.searchTheAddedProductInSearchBox("Product-1");
		pp.deleteAddedproduct();
		String actualRes = pp.getTextOfNoRecordsAfterDeletion();
		Assert.assertTrue(actualRes.contains("records"));
		System.out.println("Product deleted successfully!!!");
	}

}
