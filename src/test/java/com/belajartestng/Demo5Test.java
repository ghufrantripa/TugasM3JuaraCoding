package com.belajartestng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demo5Test {
    @Test(timeOut = 1005)
    public void test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
}
