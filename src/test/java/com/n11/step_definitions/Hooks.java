package com.n11.step_definitions;

import com.n11.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;
import java.time.Duration;


public class Hooks {

    public WebDriver driver;


    @Before
    public void setUp1(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            Allure.addAttachment(scenario.getName(),new ByteArrayInputStream(((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.BYTES)));//take screenshot in allure reports
        }
        Driver.closeDriver();
    }
}
