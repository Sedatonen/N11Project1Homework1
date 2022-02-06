package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(className = "sallerName")
    public WebElement sellerNameBtn;

    @FindBy(className = "resultText")
    public WebElement resultText;
}
