package yandex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketTest extends WebDriverSetting3 {
    @Test
    public void TestMarket() throws InterruptedException {

        chromeDriver.get("https://market.yandex.ru/");

        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@id=\"header-search\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("//*[@class=\"search2__button\"]"));

        searchField.click();
        searchField.sendKeys("Мобильные телефоны");
        searchButton.click();

        WebElement checkBox=chromeDriver.findElement(By.xpath("//*[@class=\"NVoaOvqe58\"][contains(text(), 'Apple')]"));

        checkBox.click();
        Thread.sleep(3000);
        List<WebElement> ListOfName=chromeDriver.findElements(By.xpath("//*[@class=\"n-snippet-cell2__brand-name\"]"));
        WebElement forward =chromeDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div/div[3]/a[7]"));//убрать старшилу
        WebElement numbButton=chromeDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div/div[3]/a[4]/span"));

        int numb=Integer.parseInt(numbButton.getText());
        while (numb<=10)
        {
            ListOfName=chromeDriver.findElements(By.xpath("//*[@class=\"n-snippet-cell2__brand-name\"]"));
            for (WebElement name : ListOfName)
            {
            if(!name.getText().equals("APPLE"))
                System.out.println("kto-to ne tot((");
            else System.out.println("it's ok!");

            }
            forward.click();
            Thread.sleep(3000);
            numb=Integer.parseInt(numbButton.getText());

        }
    }
    @Test
    public void PFMarket() throws InterruptedException {
        PageFactoryMarket market= PageFactory.initElements(chromeDriver,PageFactoryMarket.class);
        market.find("Мобильные телефоны");
        int numb=Integer.parseInt(market.numbButton.getText());
        while (numb<=10)
        {
            for (WebElement name : market.getAllElements())
            {
                if(!name.getText().equals("APPLE"))
                    System.out.println("kto-to ne tot((");
                else System.out.println("it's ok!");

            }
            market.forward.click();
            Thread.sleep(3000);
            numb=Integer.parseInt(market.numbButton.getText());
        }
    }
}

