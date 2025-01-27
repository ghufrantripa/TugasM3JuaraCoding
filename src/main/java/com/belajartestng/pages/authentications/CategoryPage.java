package com.belajartestng.pages.authentications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"products-category\"]/a")
    WebElement productsCategoryElement;

    @FindBy(xpath = "//*[@id=\"content-main\"]/ul/li/a")
    WebElement addProductButton;

    @FindBy(id = "id_name")
    WebElement ProductNameField;

    @FindBy(xpath = "//input[@name='_save']")
    WebElement SaveButton;

    @FindBy(xpath = "//*[@id=\"content-start\"]/ul/li")
    public WebElement SuccessMessage;

    @FindBy(xpath = "//*[@id=\"category_form\"]/div/p")
    public WebElement ErrorMessage;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickProductsCategory() {
        productsCategoryElement.click();
    }

    public void clickAddProductButton() {
        addProductButton.click();
    }

    public void fillProductNameField(String productName) {
        ProductNameField.sendKeys(productName);
    }

    public void clickSaveButton() {
        SaveButton.click();
    }

    public void waitForSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
    }

    public void waitForErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
    }

    public void addCategoryPositive(String productName) {
        clickProductsCategory();
        clickAddProductButton();
        fillProductNameField(productName);
        clickSaveButton();
        waitForSuccessMessage();
    }

    public void addCategoryNegative(String productName) {
        clickProductsCategory();
        clickAddProductButton();
        fillProductNameField(productName);
        clickSaveButton();
        waitForErrorMessage();
    }

    public String getSuccessMessageText() {
        return SuccessMessage.getText();
    }

    public String getErrorMessageText() {
        return ErrorMessage.getText();
    }
}
