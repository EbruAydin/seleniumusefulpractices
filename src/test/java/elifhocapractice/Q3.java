package elifhocapractice;

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
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Q3 {
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        createButtons(100);
    }

    @Test
    public void test02() {
        deleteButtonsAndValidate();
    }

    private void deleteButtonsAndValidate() {

        // write a function that takes a number, and clicks the "Delete" button
        //burada da delete button'i kac defa silecegimi belirledim

        for (int i = 0; i <= 30; i++) {
            driver.findElement(By.xpath("//button[@class='added-manually']")).click();
        }
    }

    @Test
    public void test03() {
        // given number of times, and then validates that given number of buttons was deleted
        //burada da geriye kalan delete buttonlarinin sayisini yaptim
        List<WebElement> deleteList = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("Remained delete buttons : " + deleteList.size());
    }


    private void createButtons(int a) {

        //click 100 times on Add Elements
        /*
        yani 100 defa add element'e click yapacam
         */
        for (int i = 0; i <= a; i++) {
            driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        }

    }


}
