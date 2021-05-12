package com.n11.stepDef;

import com.n11.pages.PersonalHomePage;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;


public class TaskFooter {

    @When("user get all the links from footer")
    public void user_get_all_the_links_from_footer() throws Exception {
        List<String> actualFooterLinks = new PersonalHomePage().allFootersLinks();
        List<String> expextedFooterLinks=new PersonalHomePage().readFileText();

        Assert.assertEquals(expextedFooterLinks,actualFooterLinks );

    }



}
