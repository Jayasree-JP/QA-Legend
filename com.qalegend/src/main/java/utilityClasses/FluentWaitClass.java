package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitClass {
	
	public void visibilityOfElement(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void alertIsPresent(WebDriver driver)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void elementToBeSelected(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void elementToBeClickableWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
