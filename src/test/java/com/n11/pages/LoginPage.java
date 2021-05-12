package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class LoginPage extends MainPage{


    @FindBy(css = ".facebook_large.medium.facebookBtn.btnLogin")
    public WebElement fbIleGiris;

    String originPageTitle;
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
