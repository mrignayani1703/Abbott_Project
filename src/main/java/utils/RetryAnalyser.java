package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

    private int maxRetryCount = 3; // Maximum number of retry attempts
    private int retryCount = 0; // Current retry count

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
    }
}
