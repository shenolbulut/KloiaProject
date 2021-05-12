package com.n11.pages;

import com.n11.myLibrary.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavorilerimPage extends MainPage{

    @FindBy(css = ".icon-base.heart-favorites-black")
    public WebElement favorilerList;

    @FindBy(css = ".column.wishListColumn")
    public List<WebElement> favoriProducts;

    @FindBy(css = ".deleteProFromFavorites")
    public WebElement deleteProd;

    @FindBy(css = ".btn.btnBlack.confirm")
    public WebElement okDeleteBtn;


    public void goToList(){
        waitAndClickForClickability(favorilerList);
    }

    public boolean verifyTheProduct(String prodName){
        List<String> elementsText = GeneralUtils.getElementsText(favoriProducts);
        for (String elm:elementsText ){
            if(elm.equals(prodName))
                return true;
        }
        return false;
    }

    public void deleteProdFromList(){
        waitAndClickForClickability(deleteProd);
        waitAndClickForClickability(okDeleteBtn);
    }

}
