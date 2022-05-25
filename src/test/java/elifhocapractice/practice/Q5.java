package elifhocapractice.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
     /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public static void tearDown() {
        //    driver i kapatiniz
        driver.close();
    }

    @Test
    public void test01() {
        //Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get(" https://www.google.com/");
       Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    public void test02(){
        //Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }
}
