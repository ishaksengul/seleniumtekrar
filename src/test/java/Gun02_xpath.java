import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Gun02_xpath {

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
        driver.get("https://demoqa.com/");
//        List<WebElement> tumLinkler = driver.findElements(By.tagName("div"));
//
//        for (WebElement w: tumLinkler) {
//            System.out.println(w.getText());
//        }
        WebElement elementLink = driver.findElement(By.xpath("(//*[@class='card-up'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", elementLink);
        elementLink.click();
        WebElement textBoxButton = driver.findElement(By.id("item-0"));
        textBoxButton.click();


//        List<WebElement> formText = driver.findElements(By.tagName("form"));
//
//        for (WebElement w:formText) {
//            System.out.println(w.getText());
//        }

        WebElement nameBox = driver.findElement(By.cssSelector("#userName"));
        nameBox.sendKeys("SengulIshak");
        WebElement mailBox = driver.findElement(By.cssSelector("#userEmail"));
        mailBox.sendKeys("sengulishak@gmail.com");
        WebElement locationBox = driver.findElement(By.cssSelector("#currentAddress"));
        locationBox.sendKeys("Rue fon tawes 4000 liege");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();

        List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));
        for (WebElement w:tumElementler) {
            System.out.println(w.getText());
        }

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }


}
