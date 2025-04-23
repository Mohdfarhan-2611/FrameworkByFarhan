package org.example.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    public static final int MAX_ATTEMPS = 3;
    public static int currentAttempt =1;

    @Override
    public boolean retry(ITestResult result) {

        if(currentAttempt<MAX_ATTEMPS){
            currentAttempt++;
            return true;
        }


        return false;
    }
}
