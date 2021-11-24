import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Gun03_Ornek {

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
        WebElement acilirMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(acilirMenu);
        select.selectByVisibleText("Books");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java");
        WebElement mercek = driver.findElement(By.id("nav-search-submit-button"));
        mercek.click();
        WebElement result = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println("toplam sonuc: "+result.getText());
        WebElement firstProuct = driver.findElement(By.xpath("//img[@class='s-image']"));
        firstProuct.click();
        WebElement backTo = driver.findElement(By.id("breadcrumb-back-link"));
        boolean bl = backTo.isDisplayed();
        System.out.println("gorunuyor mu: "+ bl);

        Assert.assertTrue(bl);


    }
}
