package com.n11.stepDef;

import com.n11.pages.FavorilerimPage;
import com.n11.pages.KozmetikKisBakPage;
import com.n11.pages.ParfumeDeodarantPage;
import com.n11.pages.PersonalHomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TaskFavorilerimDef {


    String prodName;

    @When("user goes to {string} on Personal Page")
    public void userGoesToOnPersonalPage(String kategori) {
        WebElement element = new PersonalHomePage().chooseCategory(kategori);
        new PersonalHomePage().waitAndClickForClickability(element);
    }

    @When("user goes to {string} under kategories")
    public void userGoesToUnderKategories(String subKategori) {
        WebElement element=new KozmetikKisBakPage().chooseSubCategory(subKategori);
        new KozmetikKisBakPage().waitAndClickForClickability(element);

    }

    @When("user search {string} in Brand Filter")
    public void user_search_in_Brand_Filter(String string) {
        new ParfumeDeodarantPage().searchInput.sendKeys(string, Keys.ENTER);
    }

    @When("user add the number of {int} product on the search result page to the favorits")
    public void user_add_the_number_of_product_on_the_search_result_page_to_the_favorits(Integer prodNum) {
        new ParfumeDeodarantPage().clickProductFavorits(prodNum);
        prodName=new ParfumeDeodarantPage().takeTheProductName(prodNum);

    }

    @Then("verify that user has the same product {int} in favorilerim page")
    public void verify_that_user_has_the_same_product_in_favorilerim_page(Integer prodNum) {
        FavorilerimPage favorilerimPage = new ParfumeDeodarantPage().goToFavorilerim();
        favorilerimPage.goToList();
        favorilerimPage.verifyTheProduct(prodName);
        favorilerimPage.deleteProdFromList();
    }



}
