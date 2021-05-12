package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalHomePage extends MainPage{

    @FindBy(css = ".menuLink.user")
    public WebElement hesabim;


}
