package utilityClasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void clickOnElement(WebElement element) {
		
		element.click();
	} 
	public void clearOnElement(WebElement element) {
		
		element.clear();
	}
	public void typeOnElement(WebElement element, String value) {
		
		element.sendKeys(value);
	} 
	public String getTextOfElement(WebElement element) {
		
		return element.getText();
	} 
	public String getAttributeValueOfElement(WebElement element, String attributeName) {
		
		return element.getAttribute(attributeName);
	} 	
	public String getTitleOfThePage(WebDriver driver) {
		
		return driver.getTitle();
	}
	public String getCurrentUrl(WebDriver driver) {
		
		return driver.getCurrentUrl();
	}
	public String getCSSValue(WebElement element, String propertyName) {
		
		return element.getCssValue(propertyName);
	}
	public boolean isElementDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	public boolean isElementEnabled(WebElement element) {
		
		return element.isEnabled();
	}
	public boolean isElementSelected(WebElement element) {
	
		return element.isSelected();
	}
	public boolean isElementEmpty(List<WebElement> elements) {
		
		return elements.isEmpty();
	}
	public void addThreadSleep() throws InterruptedException {
		
		Thread.sleep(3000);
	} 
	public void scrollToFindAnElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void clickOnElementJS(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public String getTextOfAlertMessage(WebDriver driver) {
		
		return driver.switchTo().alert().getText();
	} 
	public void acceptAlertMessage(WebDriver driver) {
		
		driver.switchTo().alert().accept();	
	}
	public void dismissAlertMessage(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();	
	}
	public void alertMessageSendkeys(WebDriver driver, String value) {
		
		driver.switchTo().alert().sendKeys(value);		
	}
	public void selectByIndexDropDown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValueDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectByVisibleTextDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	public boolean checkDropDownIsMultiple(WebElement element)
	{
		Select select = new Select(element);
		return select.isMultiple();
	}
	public void deselectAllOptions(WebElement element) {
		
		Select select = new Select(element);
		select.deselectAll();	
	}	
	public void deselectByIndexDropDown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public WebElement getFirstSelectedOptionDropDown(WebElement element)
	{
		Select select = new Select(element);
		return select.getFirstSelectedOption();
	}
	public List<WebElement> getAllSelectedOptionDropDown(WebElement element)
	{
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}
	public List<WebElement> getOptionsDropDown(WebElement element)
	{
		Select select = new Select(element);
		return select.getOptions();
	}
	public void pressEnterKey(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
	}
	public void dragAndDropElement(WebDriver driver, WebElement dragSource, WebElement dropTarget) {
		Actions actions = new Actions(driver);		
		actions.dragAndDrop(dragSource, dropTarget).build().perform();
	}
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
}
