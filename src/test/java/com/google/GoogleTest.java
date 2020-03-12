package com.google;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleTest extends WebDriverSetting2{
    @Test
    public void Test11()
    {
        chromeDriver.get("https://google.com/");
        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("//*[@class=\"gNO89b\"]"));
        searchField.click();
        searchField.sendKeys("Открытие");
        searchButton.click();
        List<WebElement> ListOfWebElements=chromeDriver.findElements(By.xpath("//*[@class=\"TbwUpd NJjxre\"]//cite"));

        for(WebElement we : ListOfWebElements){
            if(we.getText().contains("www.open.ru"))
            {
                chromeDriver.get("https://www.open.ru/");
                WebElement[] rate=new WebElement[4];
                String[] kostyl=new String[4];
                Double[] PrRate=new Double[4];
                rate[0]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span"));
                rate[1]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span"));
                rate[2]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[4]/div/span"));
                rate[3]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/div/span"));
               for (int i=0;i<4;i++)
               {
                   kostyl[i]=rate[i].getText().toString();
                   kostyl[i]=kostyl[i].replace(',','.');
                   PrRate[i]=Double.parseDouble(kostyl[i]);
               }
                if (PrRate[0]>PrRate[1])
                {
                    chromeDriver.get("https://google.com/");
                    System.out.println("Курс USD: Продажа "+PrRate[0]+" > покупки "+PrRate[1]);
                }
                if (PrRate[2]>PrRate[3])
                {
                    chromeDriver.get("https://google.com/");
                    System.out.println("Курс EUR: Продажа "+PrRate[2]+" > покупки "+PrRate[3]);
                }
            }
        }

    }
    @Test
    public void Test11PO()
    {
        chromeDriver.get("https://google.com/");
        PageObject2 googlePO=new PageObject2(chromeDriver);
        googlePO.find("Открытие");
        googlePO.refreshListOfElements();
        for (WebElement we:googlePO.getListOfWebElements())
        {
            if (we.getText().contains("open.ru"))
            {
                chromeDriver.get("https://www.open.ru/");
                googlePO.Preobr();
                googlePO.Res();
            }
        }
    }



}
