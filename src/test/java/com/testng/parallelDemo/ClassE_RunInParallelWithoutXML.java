package com.testng.parallelDemo;

import org.testng.annotations.Test;

public class ClassE_RunInParallelWithoutXML {

    // invocationcount -> total number of times, the method executes
    // to understand the concept, try with different threadpoolsize & invocationcount values
    @Test(threadPoolSize = 3, invocationCount = 3, timeOut = 1000)
    public void testCase1() {
        System.out.println("This is test case 1 : " + Thread.currentThread().getId());
    }
}
