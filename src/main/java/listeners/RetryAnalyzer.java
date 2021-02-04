package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * author Oleksiy Starodub
 * @date February 04, 2021
 */

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private int maxCount = 3;

    @Override

    public boolean retry(ITestResult result) {
        if (count < maxCount) {
            count++;
            System.out.println("Retry #"+count+" for test: "+result.getMethod().getMethodName());
            return true;
        }
        return false;
    }
}