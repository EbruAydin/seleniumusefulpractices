package elifhocapractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
 */

    /*
    before test yaptigimda hata verdi, bu yuzden beforeClass kullandim testlerden once
    bir de aramada isimler ust uste geliyor, nasil duzeltilir bilmiyorum
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();
    }


    @Test
    public void test(){
        // arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        //WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        // searchBox.sendKeys("Green Mile" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Green Mile" + Keys.ENTER);



    }
    @Test
    public void test2(){
        //    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        //WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        //searchBox.sendKeys("Premonition" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Premonition" + Keys.ENTER);

    }

    @Test
    public void test3(){
        //    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
       // WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
       // searchBox.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }

    @After
    public void afterTest(){

       WebElement firstResult=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc Yazisi : " + firstResult.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
