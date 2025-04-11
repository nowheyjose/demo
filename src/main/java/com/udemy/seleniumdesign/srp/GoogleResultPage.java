package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;

public class GoogleResultPage {

    private SearchWidget searchWidget;
    private ResultStat resultStat;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;

    public GoogleResultPage(final WebDriver driver) {
        this.searchWidget = new SearchWidget(driver);
        this.resultStat = new ResultStat(driver);
        this.searchSuggestion = new SearchSuggestion(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public ResultStat getResultStats() {
        return resultStat;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

}
