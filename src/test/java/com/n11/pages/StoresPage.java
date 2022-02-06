package com.n11.pages;

import com.n11.utilities.Driver;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.n11.utilities.BrowserUtils.hover;

public class StoresPage extends BasePage {

    static WebDriver driver = Driver.get();

    @FindBy(xpath = "//*[@class='letters']/span")
    public List<WebElement> storeChar;

    public WebElement getStoreLetters(int StoreChar) {
        return driver.findElement(By.xpath
                ("//*[@class='letters']/span[" + StoreChar + "]"));
    }

    @FindBy(xpath = "(//*[@class='sellerListHolder'])[4]/ul")
    public List<WebElement> getStoreNames;

    String excelFileName = "testOutputSheet.xls";//name of excel file

    String sheetName;
    HSSFSheet sheet;

    HSSFWorkbook wb = new HSSFWorkbook();
    String storeName;

    ArrayList<String[]> Store = new ArrayList<>();

    public void getAllStoreNames() throws IOException, InterruptedException {
        hover(storeChar.get(0));
        for (int i = 0; i < storeChar.size(); i++) {
            sheetName = getStoreLetters(i + 1).getText().toLowerCase(Locale.ROOT);
            sheet = wb.createSheet(sheetName);

            getStoreLetters(i + 1).click();
            Thread.sleep(750);
            Store.add(getStoreNames.get(0).getText().split("\n"));

            for (int j = 0; j < Store.get(i).length; j++) {

                sheet.createRow(j).createCell(0).setCellValue(Store.get(i)[j]);
            }
        }
        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        //Write this workbook to a stream
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public String getStoreNameFromExcel(String character,int number) throws IOException {

        FileInputStream fileInput = new FileInputStream(excelFileName);
        storeName = wb.getSheet(character).getRow(number-1).getCell(0).toString();
        fileInput.close();
        return storeName;
    }

}
