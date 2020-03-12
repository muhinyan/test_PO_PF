package ru.yandex;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> ListOfWebElements;
    PageObject(WebDriver chromeDriver)
    {
        this.chromeDriver=chromeDriver;
        searchField=chromeDriver.findElement(By.xpath("//*[@id=\"text\"]"));
        searchButton=chromeDriver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/button"));
    }
    public List<WebElement>getListOfWebElements()
    {
        return ListOfWebElements;
    }
    public void find(String searchQuery)
    {
        searchField.click();
        searchField.sendKeys(searchQuery);
        searchButton.click();
    }
    public void refreshListOfElements()
    {
        ListOfWebElements=chromeDriver.findElements(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul/li[2]/div/div/div[2]/div[1]/div[1]/a[1]/b"));//*[@class=\"serp-item\"]//b"
    }
}
