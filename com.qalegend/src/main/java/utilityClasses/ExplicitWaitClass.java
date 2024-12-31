package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	
	public void presenceOfElementLocatedWaitId(WebDriver driver,String locatorValue)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
	} 
	
	public void presenceOfElementLocatedWaitXpath(WebDriver driver,String locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public void presenceOfElementLocatedWaitName(WebDriver driver,String locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
	}
	
	public void elementToBeClickableWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void elementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void alertIsPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void visibiltyOf(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
