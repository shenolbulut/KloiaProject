package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class LoginPage extends MainPage{


    @FindBy(css = ".facebook_large.medium.facebookBtn.btnLogin")
    public WebElement fbIleGiris;

    String originPageTitle;

    /**
     *      with this method we can switch betwean windows. during switching windows, if conditions
     *  occure, it stops the execution and selenium automete that window
     * @param targetTitle
     */
    public void switchWindows(String targetTitle) {

        for (String handle : DriverFactory.get().getWindowHandles()) {
            DriverFactory.get().switchTo().window(handle);
            if (DriverFactory.get().getTitle().contains(targetTitle)) {
                return;
            }
        }
        //DriverFactory.get().switchTo().window(originPageTitle);
    }

}
