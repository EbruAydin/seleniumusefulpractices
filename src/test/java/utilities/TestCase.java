package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase {

     /*
    abstract yapmamizin nedeni bu class'tan obje uretilmesinin onune gecmektir.
     */

    protected WebDriver driver;
    //protected en dar kapsamli olan access modifier'da tercih ederiz
    //guvenlik meselesini halletmis oluruz
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        // driver.close();
    }
}
