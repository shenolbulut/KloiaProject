package com.n11.stepDef;

import com.n11.myLibrary.DriverFactory;
import com.n11.myLibrary.PropertiesReader;
import com.n11.pages.FbSubPage;
import com.n11.pages.LoginPage;
import com.n11.pages.PersonalHomePage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class LoginDef {
    @Given("user goes to the page")
    public void user_goes_to_the_page() {
        DriverFactory.get().get(PropertiesReader.get("baseUrl"));
    }

    @When("user cliks the giris yap button")
    public void user_cliks_the_giris_yap_button() {
        new LoginPage().girisYap.click();
    }

    @And("user login with facebook credentials")
    public void userLoginWithFacebookCredentials() {
        new FbSubPage().loginWithFB();
    }

    @Then("verify that user's account is displayed")
    public void verify_that_user_s_account_is_displayed() {
        assertTrue(new PersonalHomePage().hesabim.getText().equals(PropertiesReader.get("fbEmail")));
    }



}
