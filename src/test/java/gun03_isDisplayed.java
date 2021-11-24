import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class gun03_isDisplayed {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void isDisplayed(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed();
        System.out.println("Gorunuyor mu: " + gorunuyorMu);

    }

    @Test
    public void isSelected(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));

        boolean seciliMi1 = secimElementi.isSelected();
        System.out.println("sonuc1 : "+seciliMi1);
        secimElementi.click();
        boolean seciliMi2 = secimElementi.isSelected();
        System.out.println("sonuc2: "+seciliMi2);

    }

    @Test
    public void isEnabled() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi = inputKutusu.isEnabled();
        System.out.println("Aktif mi?: "+aktifMi);

        WebElement enableButton = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButton.click();
        Thread.sleep(5000);
        boolean aktifMi2 = enableButton.isEnabled();
        System.out.println("Aktif mi?: "+aktifMi2);



    }
}
