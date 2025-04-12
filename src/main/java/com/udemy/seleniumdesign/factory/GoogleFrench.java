package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//google french page can extend off of the english page instead of googlePage since it shares similar properties with the english page
class GoogleFrench extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        System.out.println("Lancement de Google.fr");
        this.driver.get("https://www.google.fr/");
        this.language.click();
    }
    // search method not needed since it is already implemented in the english page

    // same with results count method

}
