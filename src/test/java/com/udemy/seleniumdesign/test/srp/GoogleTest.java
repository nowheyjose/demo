package com.udemy.seleniumdesign.test.srp;

import com.udemy.seleniumdesign.srp.main.GoogleMainPage;
import com.udemy.seleniumdesign.srp.result.GoogleResultPage;
import com.udemy.seleniumdesign.test.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    // pass the parametrized data into the arguments for the test method
    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index) throws Exception {

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed(), "Failed suggestion check");

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed(), "Failed suggestion check");

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        System.out.println(googleResultPage.getResultStats().getStat());

    }

    // parameterized test
    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                { "selenium webdriver", 3 },
                { "docker", 2 }
        };
    }
}
