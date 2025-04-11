package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = new SearchWidget(driver);
        this.searchSuggestion = new SearchSuggestion(driver);
    }

    public void goTo() {
        this.driver.get("https://www.google.com/");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
