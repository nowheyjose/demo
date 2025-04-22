package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    // in java8 you can improve test performance by using parallel execution

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        // we get the list of validators from the home page and validate them
        // we use parallel stream to improve performance
        // we use map and a lambda expression to validate each element. the lambda
        // expression calls the validate method of each validator
        // we use forEach to iterate over the list of validators and validate each
        // element
        // we use Assert.assertTrue to validate the result of each validator
        // if any validator fails, the test will fail
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }

    // you can use testNG's @DataProvider to run the same test with different data
}

// command design pattern is useful when you have a lot of actions to perform on
// a page
// it allows you to encapsulate the actions in a class and use them in your
// tests
// it also allows you to use the same actions in different tests without
// duplicating code
// or if you have a lot of elements on a page and you want to validate them