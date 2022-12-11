package com.automate.listeners;

import com.automate.enums.ConfigProperties;
import com.automate.utils.configloader.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetry = Integer.parseInt(PropertyUtils.getPropertyValue(ConfigProperties.RETRY_COUNT));

    public Retry() throws IOException {
    }

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        try {
            if (PropertyUtils.getPropertyValue(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")) {
                value = count < maxRetry ? true : false;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
