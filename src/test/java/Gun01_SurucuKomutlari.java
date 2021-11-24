import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Gun01_SurucuKomutlari {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // tam ekran yaptik
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 10 sn bekleik
        driver.get("https://www.google.com");


        driver.navigate().to("https://amazon.com");
        driver.navigate().back(); // bir onceki sayfaya geri giter
        driver.navigate().forward(); // bir sonraki sayfaya return yapar
        driver.navigate().refresh(); // syfayi yeniler

        driver.quit(); // surucuyu komple kapatir
        driver.close(); // yanlizca acik olan sekmeyi kapatir

    }








}
