package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.n11.utilities.BrowserUtils.hover;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='cookieUsagePopIn']/span")
    public WebElement closeCookieBtn;

    @FindBy(id = "myLocation-close-info")
    public WebElement closeLocInfo;

    @FindBy(className = "hBotMenuItem")
    public WebElement storesMenu;

    @FindBy(xpath = "//*[@class='hOpenMenuContent']/a[1]")
    public WebElement seeStoresBtn;

    @FindBy(id="searchData")
    public WebElement searchArea;

    public void goStoresPage(){
        closeLocInfo.click();
        hover(storesMenu);
        seeStoresBtn.click();
    }
}
