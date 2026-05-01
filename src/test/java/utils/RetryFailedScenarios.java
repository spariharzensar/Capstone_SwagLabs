package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedScenarios implements IRetryAnalyzer {

    private int count = 0;
    private final int maxRetry = 1;

    public boolean retry(ITestResult result){
        System.out.println("Retry check for: " + result.getName());

        if(count<maxRetry){
            count++;
            System.out.println("Retry check for: " + result.getName());
            return true;
        }
        return false;
    }
}
