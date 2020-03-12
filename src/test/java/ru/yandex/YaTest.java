package ru.yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YaTest extends WebDriverSetting {
    @Test
    public void Test11() {
        chromeDriver.get("https://ya.ru/");
        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@class=\"input__control input__input\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/button"));


        searchField.click();
        searchField.sendKeys("Гладиолус");
        searchButton.click();
        List<WebElement> ListOfWebElements=chromeDriver.findElements(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul/li[2]/div/div/div[2]/div[1]/div[1]/a[1]/b"));

        for(WebElement we : ListOfWebElements){
            if(we.getText().contains("ru.wikipedia.org"))
            {
                System.out.println("Wiki есть!!!");
            }
        }

    }

    @Test
    public void Test11PO()
    {
        chromeDriver.get("https://ya.ru/");
        PageObject yaPO=new PageObject(chromeDriver);
        yaPO.find("Гладиолус");
        yaPO.refreshListOfElements();

        for (WebElement we:yaPO.getListOfWebElements())
        {
            if (we.getText().contains("ru.wikipedia.org"))
            {

                System.out.println("Wiki есть!!!");
            }
        }

    }
}

