package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class KozmetikKisBakPage extends MainPage{



    public WebElement chooseSubCategory(String subTitle){
        String path=".mainCat>[title='"+subTitle+"']";
        return DriverFactory.get().findElement(By.cssSelector(path));
    }




}
