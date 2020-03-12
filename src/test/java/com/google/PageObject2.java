package com.google;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject2 {
    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> ListOfWebElements;
    public  WebElement[] rate=new WebElement[4];
    public String[] kostyl=new String[4];
    public Double[] PrRate=new Double[4];
    PageObject2(WebDriver chromeDriver)
    {
        this.chromeDriver=chromeDriver;
        searchField=chromeDriver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]"));//*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[2]/input?
        searchButton=chromeDriver.findElement(By.xpath("//*[@class=\"gNO89b\"]"));
        rate[0]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span"));
        rate[1]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span"));
        rate[2]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[4]/div/span"));
        rate[3]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/div/span"));
    }
    public void find(String searchQuery)
    {
        searchField.click();
        searchField.sendKeys(searchQuery);
        searchButton.click();
    }
    public List<WebElement> getListOfWebElements()
    {
        return ListOfWebElements;
    }
    public void refreshListOfElements()
    {
        ListOfWebElements=chromeDriver.findElements(By.xpath("//*[@class=\"TbwUpd NJjxre\"]//cite"));
    }
    public void Preobr()
    {
        for (int i=0;i<4;i++)
        {
            kostyl[i]=rate[i].getText().toString();
            kostyl[i]=kostyl[i].replace(',','.');
            PrRate[i]=Double.parseDouble(kostyl[i]);
        }
    }
    public void Res()
    {
        for(int i=0;i<2;i++)
        {
            if (i == 0 && PrRate[i]>PrRate[i++])
            {
                System.out.println("Курс USD: Продажа "+PrRate[i]+" > покупки "+PrRate[i++]);
                i--;
            }
            if (i == 1 && PrRate[i]>PrRate[i++])
            {
                System.out.println("Курс EUR: Продажа "+PrRate[i]+" > покупки "+PrRate[i++]);
            }
        }
    }
}
