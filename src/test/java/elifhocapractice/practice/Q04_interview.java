package elifhocapractice.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Q04_interview {
    /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz
*/

    //Not : https://www.guru99.com/chrome-options-desiredcapabilities.html

    /*
    note :
    JavaScriptExecutor nedir?
    JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü aracılığıyla çalıştırmaya yardımcı olan bir Arayüzdür.
    JavaScriptExecutor, javascript'i seçilen pencerede veya geçerli sayfada çalıştırmak için "executescript" ve "executeAsyncScript"
    olmak üzere iki yöntem sunar.
    JavaScriptExecutor'a neden ihtiyacımız var?
    Selenium Webdriver'da, bir web sayfasındaki işlemleri tanımlamak ve gerçekleştirmek için
    XPath, CSS vb. gibi konum belirleyiciler kullanılır.
    Bu konum belirleyicilerin çalışmaması durumunda JavaScriptExecutor'ı kullanabilirsiniz.
    Bir web öğesinde istenen bir işlemi gerçekleştirmek için JavaScriptExecutor'ı kullanabilirsiniz.
    Selenium, javaScriptExecutor'ı destekler. Ekstra bir eklenti veya eklentiye gerek yoktur.
    JavaScriptExecutor kullanmak için komut dosyasında (org.openqa.selenium.JavascriptExecutor) içe aktarmanız yeterlidir.
            executeScript aracılığıyla sayfayı 1000 piksel kaydırın.
            Javascript yöntemi ScrollBy(), web sayfasını belirli piksel sayısına kaydırır.
            ScrollBy() yöntemlerinin sözdizimi şöyledir:
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            Örnek:
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://www.teknosa.com/");
    }

    @AfterClass
    public static void tearDown() {
        //    driver i kapatiniz
        driver.close();
    }

    @Test
    public void test01() {

        // arama cubuguna oppo yazip enter deyiniz
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        //    sonuc sayisini yazdiriniz
        WebElement result=driver.findElement(By.xpath("//*[@class='plp-info']"));
        String resulttext[]=result.getText().split(" ");
        //System.out.println(Arrays.toString(resulttext));
        System.out.println("Arama sonucu : " + Arrays.stream(resulttext).findFirst().orElseThrow());

        //    cikan ilk urune tiklayiniz
         driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

         //    sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();

        //    sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        //    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='cart-sum-body']")).getText());

        //    Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@type='button']")).click();


        //    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("//*[text()='Teknosa’ya hoş geldiniz']")).getText());

    }
}
