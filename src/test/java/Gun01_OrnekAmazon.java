import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Gun01_OrnekAmazon {

    WebDriver driver;

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Baby stroller" + Keys.ENTER);
        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();
        WebElement urunFiyat = driver.findElement(By.xpath("//td[@class='a-span12']"));
        System.out.println(urunFiyat.getText());


    }
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
//        WebElement pop = driver.findElement(By.xpath("(//div[@role='none'])[5]"));
//        pop.sendKeys(Keys.ARROW_DOWN);
//        pop.click();

        WebElement element1 = driver.findElement(By.xpath("(//div[@role='none'])[5]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element1);
        element1.click();


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement aramaKutusuGoogle = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusuGoogle.sendKeys("Kemal Ozden");
        aramaKutusuGoogle.submit();
    }


}
