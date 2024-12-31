package utilityClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;




public class ScreenshotClass {

	public static void takeScreenshot(WebDriver driver, String testcasename) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // TakesScreenshot is the interface and then inistantiate as objectname as ts
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE); // File is the class and use getScreenshotAs method
																	// to store as File explain this two lines in interview..

		String dest = System.getProperty("user.dir") + "//Test_Evidence"; // create a folder inside project named 'Test
																			// Evidence' & We use user.dir used get the user path

		File f1 = new File(dest);
		if (!f1.exists()) { // this is to check if already a folder is there
			f1.mkdirs(); // this is to create a file

		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		// Date import java.util

		String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + testcasename + timeStamp + ".png"; // format
																													// to
																													// save
																													// file
		File finalDestination = new File(destinationPath);
		FileHandler.copy(screenshotFile, finalDestination); //filehandler is used to copy the screenshot to the test evidence folder..
	}

}
