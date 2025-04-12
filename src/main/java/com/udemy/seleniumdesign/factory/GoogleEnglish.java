package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.List;

class GoogleEnglish extends GooglePage {

    // protected because other pages will extend from english page. French will be
    // able to access the driver and wait objects
    protected WebDriver driver;
    protected WebDriverWait wait;

    // you cannot put the search box and buttons in the abstract class because they
    // might be different in other languages
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnk")
    private WebElement searchBtn;

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        System.out.println("Launching Google English");
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void search(String keyword) {
        System.out.println("Searching " + keyword + " in Google English");
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ENTER);
        // the search suggestions wouldn't go away so it broke my test. removing the
        // buttons
        // this.wait.until((d) -> this.searchBtn.isDisplayed());
        // this.searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        System.out.println("Getting results count from Google English");
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }

}
