package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Function;
import java.util.Map;

// Factory class for Google
// This class is responsible for creating the Google page objects based on the requirements (in this case, the browser launcher type or language being used)

public class GoogleFactory {

    // Instead of using a bunch of if-else's to create the page object,
    // we can use java8's function interface to create the page object
    // this is making use of a lambda expression that returns the page
    // object of the language
    // these are static final because they are constants and will not change
    // same with the map
    private static final Function<WebDriver, GooglePage> ENG = (driver) -> new GoogleEnglish(driver);
    private static final Function<WebDriver, GooglePage> FR = (driver) -> new GoogleFrench(driver);
    private static final Function<WebDriver, GooglePage> SA = (driver) -> new GoogleArabic(driver);

    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    // static block to initialize the map with the language and the page object
    static {
        MAP.put("en", ENG);
        MAP.put("fr", FR);
        MAP.put("sa", SA);
    }

    public static GooglePage get(String language, WebDriver driver) {
        // get returns the lambda expression and .apply triggers the lambda expression
        // and returns the necessary driver
        return MAP.get(language).apply(driver);
    }

}
