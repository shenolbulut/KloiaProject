package com.n11.pages;


import com.n11.myLibrary.DriverFactory;
import com.n11.myLibrary.GeneralUtils;
import com.n11.myLibrary.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FbSubPage extends LoginPage {

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(css = "#pass")
    public WebElement passwordInput;

    @FindBy(name = "login")
    public WebElement girisYapBttn;

    @FindBy(id = "acceptContract")
    public WebElement uyelikKabul;

    @FindBy(id = "confirmBtn")
    public WebElement onaylıyorumBtn;

    @FindBy(css = "#userAgreementLB>.content>.closeBtn")
    public WebElement closeBtn;



    /**
     *      with this method we can log in facebook pobup. inside method I used different methods from
     * user page and main page,
     */
    public void loginWithFB(){
        waitAndClickForClickability(fbIleGiris);
        GeneralUtils.waitFor(5);
        originPageTitle= DriverFactory.get().getWindowHandle();
        switchWindows("Facebook");
        emailInput.sendKeys(PropertiesReader.get("fbEmail"));
        passwordInput.sendKeys(PropertiesReader.get("fbPassword"));
        waitAndClickForClickability(girisYapBttn);
        GeneralUtils.waitFor(10);
        switchWindows(originPageTitle);
        waitAndClickForClickability(uyelikKabul);
        waitAndClickForClickability(onaylıyorumBtn);
        GeneralUtils.waitFor(5);
        waitAndClickForClickability(closeBtn);


    }


}
