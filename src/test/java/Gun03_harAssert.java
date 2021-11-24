import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Gun03_harAssert {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        driver.get("https://amazon.com");
        String baslik = driver.getTitle();
        if(baslik.contains("car")){
            System.out.println("Geciyor : "+baslik);
        }else{
            System.out.println("Gecmiyor.. Baslik: "+baslik);
        }

        boolean iceritorMu = baslik.contains("car");
        Assert.assertTrue(iceritorMu); // baslikta car var mi soruyor olmayinca test basarisiz


    }

    @Test
    public void test02(){
        driver.get("https://amazon.com");
        String baslik = driver.getTitle();

        boolean falseMu = baslik.contains("Google");
        Assert.assertFalse(falseMu); //passe

    }

    @Test
    public void test03(){
        driver.get("https://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertEquals(baslik, "Amazon.com"); // beklenen ve gerceklesen verileri karsilastiriyor

    }



}
