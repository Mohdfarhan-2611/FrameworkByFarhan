package org.example.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_ATTEMPS = 3;
    private static int currentAttempt =1;

    @Override
    public boolean retry(ITestResult result) {
                //1<3 2<3 3<3
        if(currentAttempt<MAX_ATTEMPS){
            currentAttempt++; //2 3
            return true;
        }


        return false;
    }
}
