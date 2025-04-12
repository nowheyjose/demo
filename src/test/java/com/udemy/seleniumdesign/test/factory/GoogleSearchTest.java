package com.udemy.seleniumdesign.test.factory;

import com.udemy.seleniumdesign.test.BaseTest; // Ensure this is the correct package for BaseTest

import org.testng.annotations.DataProvider;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;

import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {

        // Create the GooglePage object based on the language. This is the Factory
        // pattern.
        // In each of our language classes, we remove the public modifier from the
        // class, this is because
        // we are not supposed to create the object yourself. the whole point is the
        // factory does it for you
        // so using new GoogleEnglishPage() is not allowed.
        // Factory pattern is used to create objects without specifying the exact class
        // of
        // object that will be created.

        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();

        System.out.println("Results count: " + resultCount);
    }

    // Data provider method to provide test data. This is to parameterize the test.
    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                { "en", "Selenium" },
                { "fr", "design patterns" },
                { "sa", "docker" }
        };
    }

}
