package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreDetailPage extends BasePage{

    @FindBy(xpath = "//*[@class='tab']//li[2]")
    public WebElement commentsBtn;

    @FindBy(className = "selectedReview")
    public WebElement commentsText;
}
