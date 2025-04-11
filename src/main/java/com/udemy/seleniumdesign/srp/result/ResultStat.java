package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "resultStats")
    private WebElement stat;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return stat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> this.stat.isDisplayed());
    }

}
