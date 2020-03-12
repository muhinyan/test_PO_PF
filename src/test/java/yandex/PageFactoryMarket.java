package yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryMarket {
    private WebDriver chromeDriver;
    private String url="https://market.yandex.ru/";

    @FindBy(how = How.ID,id="header-search")
    WebElement searchField;
    @FindBy(how = How.XPATH,using="//*[@class=\\\"search2__button\\\"]")
    WebElement searchButton;
    @FindBy(how = How.XPATH,using="//*[@class=\"NVoaOvqe58\"][contains(text(), 'Apple')]")
    WebElement checkBox;
    @FindBy(how = How.XPATH,using="/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div/div[3]/a[7]")
    WebElement forward;
    @FindBy(how = How.XPATH,using="/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div/div[3]/a[4]/span")
    WebElement numbButton;
    @FindAll(@FindBy(how= How.XPATH, using = "//*[@class=\"n-snippet-cell2__brand-name\"]"))
    List<WebElement> allElements;

    public PageFactoryMarket(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        chromeDriver.get(url);
    }
    public void find (String searchQuery){
        searchField.click();
        searchField.sendKeys(searchQuery);
        searchButton.click();
        checkBox.click();
    }
    public List<WebElement> getAllElements() {
        return allElements;
    }




}
