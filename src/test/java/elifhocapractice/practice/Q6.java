package elifhocapractice.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;

public class Q6 {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");

    }

    @AfterClass
    public static void tearDown() {
        //    driver i kapatiniz
       // driver.close();
    }

    @Test
    public void test01() {
        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectObj=new Select(dropDown);
        selectObj.selectByVisibleText("Books");
        //selectObj.selectByValue("search-alias=automotive-intl-ship");
        //selectObj.selectByIndex(5);

        //    kategorilerin hepsini konsola yazdiralim
        selectObj.getOptions().stream().map(WebElement::getText).
                forEach(System.out::println);

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables" + Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.

        WebElement result=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonucYazisi=result.getText().split(" ");

        Arrays.stream(sonucYazisi).limit(4).skip(3).
               forEach(t-> System.out.println("sonuc sayisi : " + t));


        // 5. Sonucların Les Miserables i icerdigini assert edelim
        Assert.assertTrue(result.getText().contains("Les Miserables"));
    }

}
