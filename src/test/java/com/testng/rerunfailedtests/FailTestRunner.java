package com.testng.rerunfailedtests;

import org.testng.TestNG;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.List;

public class FailTestRunner {

    @AfterTest
    public void runFailedTests() {
        TestNG obj = new TestNG();

        List<String> list = new ArrayList<String>();
        list.add("./test-output/testng-failed.xml");
        obj.setTestSuites(list);
        obj.run();
    }
}
