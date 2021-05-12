package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class KozmetikKisBakPage extends MainPage{



    /**
     *      this method is very useful method that can return us all the sub kategories of "kozmetik.."
     * so no need to intialize all the sub element one by one.
     * @param subTitle
     * @return WebElemet
     */
    public WebElement chooseSubCategory(String subTitle){
        String path=".mainCat>[title='"+subTitle+"']";
        return DriverFactory.get().findElement(By.cssSelector(path));
    }




}
