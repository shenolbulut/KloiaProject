package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ParfumeDeodarantPage extends MainPage{


    @FindBy(css = ".filter-top-search>input")
    public WebElement searchInput;

    @FindBy(css = ".filter-top-search>i")
    public WebElement searchBtn;

    @FindBy(css = "[data-position]")
    public List<WebElement> products;

    @FindBy(css = ".icon.iconFavorites")
    public WebElement favorilerimPage;



    public void clickProductFavorits(int prodNum){
        String path="[data-position='"+prodNum+"']>a>div>.itemize-fav-btn.itemize-favorite";
        WebElement favorilerIcon = DriverFactory.get().findElement(By.cssSelector(path));
        waitAndClickForClickability(favorilerIcon);


    }

    public String takeTheProductName(int prodNum){
        String path="[data-position='"+prodNum+"']>a>h3";
        WebElement prodElement = DriverFactory.get().findElement(By.cssSelector(path));
        return prodElement.getText();
    }

    public FavorilerimPage goToFavorilerim(){
        waitAndClickForClickability(favorilerimPage);
        return new FavorilerimPage();
    }




}
