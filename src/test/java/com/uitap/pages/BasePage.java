package com.uitap.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage
{
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(){
        //BasePage.driver = driver;
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
            Find(locator).click();
    }

    public void submitElement(String locator){
        Find(locator).submit();
    }


    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByVisibleText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator)
    {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator)
    {
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator,int row, int column){
        String cellIneed= locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellIneed).getText();
    }

    
    public void setValueToTable(String locator,int row, int column,String text){
        String cellToFill= locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(text);
    }

    public void switchToIframe(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String TextFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsEnable(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
    
}
