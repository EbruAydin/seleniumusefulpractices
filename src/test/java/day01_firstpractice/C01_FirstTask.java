package day01_firstpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_FirstTask {

    WebDriver driver;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }


    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-home']")).isDisplayed());
        /*
        if (anaSayfa.isDisplayed())
            System.out.println("anasayfa goruntuleniyor");
        else System.out.println("anasayfa goruntulenmiyor");
        */

        //4. Click on 'Signup / Login' button
        WebElement signUpLogIn = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpLogIn.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue("New User Signup!",  driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
       // System.out.println(newUser.isDisplayed() ? "New User Signup! is visible, Test PASSED" : "Test FAILED");


        //6. Enter name and email address
        WebElement enterName = driver.findElement(By.xpath("//input[@name='name']"));
        enterName.sendKeys("ebru");

        WebElement emailAdress = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailAdress.sendKeys("ebay9@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue("ekran cikitisi gelmedi", driver.findElement(By.xpath("(//b)[1]")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderButton=driver.findElement(By.xpath("(//div[@class='radio-inline'])[1]"));
        WebElement genderButton2=driver.findElement(By.xpath("(//div[@class='radio-inline'])[2]"));
        if(!genderButton.isSelected())
            genderButton.click();

        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.id("password")).sendKeys("password");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.name("newsletter")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@name='optin']")).click();

        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("blabla");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("bla");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Aydin");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("blabla");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("23");
        driver.findElement(By.xpath("//select[@name='country']")).sendKeys("United States");
        driver.findElement(By.xpath("//select[@name='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@name='months']")).sendKeys("April");
        driver.findElement(By.xpath("//select[@name='years']")).sendKeys("2000");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Bayern");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Erlangen");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("91080");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("05057714562");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();


        //14. 'HESAP OLUŞTURULDU!' görünür
        Assert.assertTrue("gorunmedi",driver.findElement(By.xpath("//b")).isDisplayed());


        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

    }

    }
