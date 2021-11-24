import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Gun03_Dropdown {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdowntest(){
        driver.get("https://amazon.com");
        WebElement acilirMenuBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(acilirMenuBox);
        select.getFirstSelectedOption(); // birinci menuyu getirir

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        select.selectByVisibleText("Baby"); // yazzigimiz menuyu getirir
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        select.selectByIndex(5); // 5. siraaki menuyu getirir
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        select.selectByValue("search-alias=aps"); // value = egeri ne ise onu yaziyoruz ve o menuyu getiriyor

        //acilir menu elementlerinin tamamini almak icin
        List<WebElement> tumSecenekler = select.getOptions();
        for (WebElement w:tumSecenekler) {
            System.out.println(w.getText());
        }

        System.out.println("Toplam kategori sayisi: "+tumSecenekler.size());

        //yanlizca secili olan menuyu return yapar
        WebElement secili = select.getFirstSelectedOption();
        System.out.println("secili olan menu: "+secili.getText());

    }
}
