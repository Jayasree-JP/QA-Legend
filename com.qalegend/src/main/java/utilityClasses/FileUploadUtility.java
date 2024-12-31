package utilityClasses;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadUsingSendKeys(WebElement element, String path) {

		element.sendKeys(path);
	}

}
