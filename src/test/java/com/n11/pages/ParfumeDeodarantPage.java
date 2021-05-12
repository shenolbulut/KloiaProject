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



    /**
     *          in task 2 it is asked to clik 7. product. so this method is used for this. It takes the number
     * and took it manupulated css locator. so you can change the product just changing the number. it is
     * resuablity.
     *
     * @param prodNum
     */
    public void clickProductFavorits(int prodNum){
        String path="[data-position='"+prodNum+"']>a>div>.itemize-fav-btn.itemize-favorite";
        WebElement favorilerIcon = DriverFactory.get().findElement(By.cssSelector(path));
        waitAndClickForClickability(favorilerIcon);

    }

    /**
     *      This method is used with previus method. to take the product name and compare it after
     *  favoriler page. Logic is the same. just choose the number of element and take it's name.
     *
     * @param prodNum
     * @return String
     */

    public String takeTheProductName(int prodNum){
        String path="[data-position='"+prodNum+"']>a>h3";
        WebElement prodElement = DriverFactory.get().findElement(By.cssSelector(path));
        return prodElement.getText();
    }

    /**
     *      with this method we can easly go to favorilerim page. return type is FavorilerimPage so
     *  you can call directly some variables from return object with this method
     *
     * @return FavorilerimPage
     */
    public FavorilerimPage goToFavorilerim(){
        waitAndClickForClickability(favorilerimPage);
        return new FavorilerimPage();
    }




}
