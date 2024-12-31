package retryAnalyser;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserClass implements IRetryAnalyzer {

	private int retryCount = 0; //how many times we have run that test case..
	private static final int maximumRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < maximumRetryCount) {

			retryCount++;
			return true;
		}
		return false;
	}

}
