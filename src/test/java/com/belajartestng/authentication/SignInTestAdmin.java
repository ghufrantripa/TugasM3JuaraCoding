package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.pages.authentications.DashboardPage;
import com.belajartestng.pages.authentications.SignInPage;
import com.belajartestng.pages.authentications.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTestAdmin {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;
    private CategoryPage categoryPage;


    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

    @Test
    public void signInTest() {
        driver.get("http://localhost:8000/admin");

        signInPage = new SignInPage(driver);
        signInPage.loginActivity("admin", "123");

        dashboardPage = new DashboardPage(driver);
        String expectedWelcomeMessage = "Welcome to Demo SQA Testing Portal";
        String actualWelcomeMessage = dashboardPage.getTextWelocmeHeadingElement();
        Assert.assertEquals(actualWelcomeMessage.toLowerCase(), expectedWelcomeMessage.toLowerCase(), "Login failed: Welcome message mismatch");

        categoryPage = new CategoryPage(driver);

        categoryPage.addCategoryPositive("Valid Category Name");
        String successMessage = categoryPage.SuccessMessage.getText();
        Assert.assertTrue(successMessage.contains("was added successfully"), "Failed to add category: Success message not displayed");

        categoryPage.addCategoryNegative("");
        String errorMessage = categoryPage.ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Please correct the error below."), "Validation failed: Error message not displayed");
    }
}
