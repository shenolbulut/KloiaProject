package com.n11.pages;

import com.n11.myLibrary.DriverFactory;
import com.n11.myLibrary.GeneralUtils;
import com.n11.myLibrary.PropertiesReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MainPage {

    public MainPage(){

        PageFactory.initElements(DriverFactory.get(), this);

    }

    public void waitAndClickForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.get(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public WebElement chooseCategory(String title){
        String path="[title='"+title+"']";
        return DriverFactory.get().findElement(By.cssSelector(path));
    }

    public WebElement footerElements(String name){
        String path="//*[@class='fWrapper']//div[@class='column ']//li/a[contains(.,'"+name+"')]";
        return DriverFactory.get().findElement(By.xpath(path));
    }

    /**
     *      this methoc is used for task3. I took all the footer element's href attribute and
     *  put them inside a list.
     * @return List
     */

    public List<String> allFootersLinks(){
        GeneralUtils.scrolToPage();
        closeToPopub();
        String path="//*[@class='fWrapper']//div[@class='column ']//li/a";
        GeneralUtils.waitFor(5);
        List<WebElement> footerElements=DriverFactory.get().findElements(By.xpath(path));
        List<String> allFootersLinks=new ArrayList<>();
        for(WebElement footerElem:footerElements){
            allFootersLinks.add(footerElem.getAttribute("href"));
        }
        return allFootersLinks;
    }

    /**
     * with this method I can close the popubs. I also used switchWindows method inside
     */
    public void closeToPopub(){

        new LoginPage().switchWindows("n11.com - Hayat Sana Gelir");
        try {
            waitAndClickForClickability(DriverFactory.get()
                    .findElement(By.xpath("(//*[@class='seg-popup-close'])[2]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new LoginPage().switchWindows("n11.com - Hayat Sana Gelir");
    }



    /**
     * I used this method for Task3. with this method we can read from .text file with the help of
     * Scanner class and FileReader class
     */
    public List<String> readFileText() throws Exception {
        Scanner scan=new Scanner(new FileReader("links.text"));
        List<String> expectedLinkList=new ArrayList<>();
        while (scan.hasNext()){
            expectedLinkList.add(scan.nextLine());
        }

        return expectedLinkList;
    }

    @FindBy(css = ".btnSignIn")
    public WebElement girisYap;

    @FindBy(linkText = "https://www.n11.com/hesabim/istek-listelerim")
    public WebElement favorilerim;








}
