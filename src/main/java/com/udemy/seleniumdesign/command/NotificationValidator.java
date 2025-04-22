
package com.udemy.seleniumdesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {

    // receive two elements
    private final WebElement button;
    private final WebElement notification;

    // making constructor
    // button is the element that triggers the notification
    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }
    // we are not finding the elements here
    // we are receiving them from the test class

    @Override
    public boolean validate() {
        this.button.click();
        boolean isPresent = this.notification.isDisplayed(); // true
        // require that the notification is displayed for 4 seconds. like this is part
        // of the test
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean isHidden = this.notification.isDisplayed(); // false
        return isPresent && (!isHidden);
    }

}
