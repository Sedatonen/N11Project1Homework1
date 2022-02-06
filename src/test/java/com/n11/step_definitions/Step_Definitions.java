package com.n11.step_definitions;

import com.n11.pages.BasePage;
import com.n11.pages.SearchPage;
import com.n11.pages.StoreDetailPage;
import com.n11.pages.StoresPage;
import com.n11.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static org.testng.Assert.*;

public class Step_Definitions {

    BasePage basePage = new BasePage();
    StoresPage storesPage = new StoresPage();
    SearchPage searchPage = new SearchPage();
    StoreDetailPage storeDetailPage = new StoreDetailPage();

    @Given("User go to the stores page")
    public void user_go_to_the_stores_page() {
        assertTrue(Driver.get().getCurrentUrl().contains("n11"),"Verify Home Page");

        basePage.goStoresPage();
        assertTrue(Driver.get().getCurrentUrl().contains("magaza"),"Verify Stores Page");
    }

    @Given("All stores write to excel")
    public void all_stores_write_to_excel() throws IOException, InterruptedException {
        storesPage.closeCookieBtn.click();
        storesPage.getAllStoreNames();
    }

    @When("User select on {string} at {int}nd store from excel")
    public void userSelectOnAtNdStoreFromExcel(String character, int number) throws IOException {
        String storeName = storesPage.getStoreNameFromExcel(character, number);

        basePage.searchArea.sendKeys(storeName + Keys.ENTER);
        assertTrue(searchPage.resultText.getText().contains(storeName),"Verify Search Page");
    }

    @Then("user go to the chosen store page and control comments")
    public void user_go_to_the_chosen_store_page_and_control_comments() {
        searchPage.sellerNameBtn.click();
        storeDetailPage.commentsBtn.click();

        assertTrue(storeDetailPage.commentsText.isDisplayed(),"Verify Comments");
        System.out.println(storeDetailPage.commentsText.getText());
    }
}
