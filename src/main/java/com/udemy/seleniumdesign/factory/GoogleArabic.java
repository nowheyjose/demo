package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        System.out.println("Launching Arabic Google");
        language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((d) -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
        // using the PARENT search method from English
        super.search(keyword);
    }
}
