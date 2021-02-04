package listeners;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * author Oleksiy Starodub
 * @date February 04, 2021
 */

public class RetryTestListener implements IAnnotationTransformer {
    public RetryTestListener() {
    }
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null)    {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}