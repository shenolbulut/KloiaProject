package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MainPage{

    @FindBy(css = "pro-title_main ")
    public WebElement productName;

    @FindBy(css = ".icon.iconFavorites")
    public WebElement favorilerimPage;


}
